import { Component } from "@angular/core";

@Component({
  selector: 'ffe-root',
  template: `
  <div><h1>{{pageTitle}}</h1>
    <ffe-products></ffe-products>
  </div>
`
})
export class AppComponent {
  pageTitle: string = "Fun Front End Application"
}