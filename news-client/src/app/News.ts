/**
 * Created by Veronika Korozhan on March 5, 2018.
 */
import {Category} from "./Category";
import {DatePipe} from "@angular/common";

const datePipe = new DatePipe('en-EN');

export class News {
  id: string;
  publicDate: string = datePipe.transform(Date.now(), 'yyyy-MM-dd');
  title: string;
  body: string;
  checked: boolean = false;
  category: Category
}

