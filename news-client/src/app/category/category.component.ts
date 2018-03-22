import {Component, OnInit} from '@angular/core';
import {Category} from "../Category";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  categories: Category[];
  categoryName: string;

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.getCategories();
  }

  private getCategories() {
    this.http.get('api/categories')
      .subscribe((categories: Category[]) => this.categories = categories);
  }

  save() {
    this.http.post('api/categories', new Category(null, this.categoryName))
      .subscribe(() => this.getCategories());
  }
}
