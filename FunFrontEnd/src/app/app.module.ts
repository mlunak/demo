import { NgModule } from "@angular/core";
import { AppComponent } from "./app.component";
import { BrowserModule } from "@angular/platform-browser";
import {HttpClientModule} from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import { ProductListComponent } from "./products/product-list.component";
import { ConvertToSpacesPipe } from "./shared/convert-to-spaces.pipe";
import { StarComponent } from "./shared/star.component";

@NgModule(
  {
    declarations: [
      AppComponent,
      ProductListComponent,
      StarComponent,
      ConvertToSpacesPipe
    ],
    imports: [
      BrowserModule,
      FormsModule,
      HttpClientModule
    ],
    bootstrap: [AppComponent]
  }
)
export class AppModule {
}
