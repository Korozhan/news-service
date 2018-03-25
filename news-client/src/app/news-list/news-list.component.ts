import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {News} from "../News";
import {Category} from "../Category";
import {Observable} from "rxjs/Observable";
import {filter, map, mergeAll} from "rxjs/operators";

@Component({
  selector: 'app-news-list',
  templateUrl: './news-list.component.html',
  styleUrls: ['./news-list.component.css']
})
export class NewsListComponent implements OnInit {
  news: News[];
  categories: Category[];
  defaultCategory = new Category(null, 'Select category');
  category: string;

  constructor(private http: HttpClient,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.queryParams.subscribe(
      (params: Params) => {
        this.category = params.hasOwnProperty('category')
          ? params['category'] : this.defaultCategory.displayName;
        this.search();
      });
    this.http.get('/api/categories').subscribe(
      (categories: Category[]) => this.categories = categories);
  }

  search() {
    let params = {};
    if (this.category !== this.defaultCategory.displayName) {
      params = {category: this.category};
    }
    this.http.get<News[]>('/api/news', {params: params})
      .subscribe((news: News[]) => {
        this.news = news
      });
  }

  remove() {
    Observable
      .from(this.news)
      .pipe(
        filter(news => news.checked),
        map(news => this.http.delete('/api/news/' + news.id)),
        mergeAll()
      ).subscribe(() => this.search());
  }
}
