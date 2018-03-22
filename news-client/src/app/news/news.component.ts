import {Component, OnInit} from '@angular/core';
import {Category} from "../Category";
import {News} from "../News";
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {
  defaultCategory = new Category(null, 'Please, select category');
  news = new News();
  categoryName: string = null;
  categories: Category[];

  constructor(private http: HttpClient,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.http.get('/api/categories').subscribe(
      (categories: Category[]) => this.categories = categories);
    this.route.paramMap.subscribe((params: ParamMap) => {
      if (params.has('id')) {
        this.http.get('/api/news/' + params.get('id'))
          .subscribe((news: News) => {
            this.news = news;
            this.categoryName = news.category.displayName;
          });
      }
    });
  }

  save() {
    this.news.category = this.categories.find(
      category => category.displayName === this.categoryName);

    (!!this.news.id
        ? this.http.put('/api/news', this.news)
        : this.http.post('/api/news', this.news)
    ).subscribe(() => this.navigateToNewsList());
  }

  navigateToNewsList() {
    return this.router.navigateByUrl('/news');
  }

}
