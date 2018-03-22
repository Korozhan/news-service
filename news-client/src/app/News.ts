/**
 * Created by Veronika Korozhan on March 5, 2018.
 */
import {Category} from "./Category";

export class News {
  id: string;
  publicDate: Date = new Date();
  title: string;
  body: string;
  checked: boolean = false;
  category: Category
}

