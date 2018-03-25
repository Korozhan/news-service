import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {NewsListComponent} from './news-list/news-list.component';
import {NewsComponent} from "./news/news.component";
import {CategoryComponent} from "./category/category.component";

const routes: Routes = [
  {path: 'news', component: NewsListComponent},
  {path: 'news/add', component: NewsComponent},
  {path: 'news/edit/:id', component: NewsComponent},
  {path: 'categories', component: CategoryComponent},
  {path: '**', component: NewsListComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutesModule {
}
