import { NgModule } from "@angular/core";
import { AppComponent } from "./app.component";
import { BrowserModule } from "@angular/platform-browser";
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import { ProductListComponent } from "./products/product-list.component";
import { ConvertToSpacesPipe } from "./shared/convert-to-spaces.pipe";
import { StarComponent } from "./shared/star.component";
import { AppHttpInterceptor } from "./shared/app-http-interceptor";

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
    bootstrap: [AppComponent],
    providers: [
      { provide: HTTP_INTERCEPTORS, useClass: AppHttpInterceptor, multi: true }
    ]
  }
)
export class AppModule {
}
