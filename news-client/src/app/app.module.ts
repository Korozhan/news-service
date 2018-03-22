import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { CategoryComponent } from './category/category.component';
import { NewsComponent } from './news/news.component';
import { NewsListComponent } from './news-list/news-list.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {AppRoutesModule} from "./app-routing.module";


@NgModule({
  declarations: [
    AppComponent,
    NewsComponent,
    NewsListComponent,
    CategoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutesModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
