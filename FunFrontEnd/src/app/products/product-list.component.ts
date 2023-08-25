import { Component, OnInit, OnDestroy } from "@angular/core";
import { IProduct } from "./product";
import { ProductService } from "./product.service";
import { Subscription } from "rxjs";

@Component({
    selector: "ffe-products",
    templateUrl: './product-list.component.html',
    styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit, OnDestroy {
    private _listFilter: string = "";
    private _secret: string = "changeTo: fun"
    private _subscrProducts! : Subscription

    pageTitle: string = "Product List"
    imageWidth: number = 50;
    imageMargin: number = 2;
    showImage = false;
    filteredProducts: IProduct[] = []
    products: IProduct[] = []
    errorMessage:string =""

    constructor(private productService: ProductService){
    }

    toggleImage(): void {
        this.showImage = !this.showImage
    }
    ngOnInit(): void {
        this._subscrProducts = this.productService.getProducts().subscribe(
            {
                next: response => {
                    this.products = response.products
                    this.filteredProducts = this.performFiler(this._listFilter)
                },
                error: err => this.errorMessage = err
                
            }
        )
    }
    ngOnDestroy(): void {
        this._subscrProducts.unsubscribe
    }
    private performFiler(filterBy: string): IProduct[]{
        return this.products.filter((product:IProduct) => product.productName.toLocaleLowerCase().includes(filterBy.toLocaleLowerCase()));
    }
    get secret(): string {
        return this._secret
    }
    set secret(secret:string){
        this._secret = secret
    }
    get listFilter() : string{
        return this._listFilter
    }
    set listFilter(listFilter:string){
        this._listFilter = listFilter
        this.filteredProducts = this.performFiler(listFilter)
    }
    onRatingClicked(event:string):void {
        this.pageTitle = 'See me in pretty cars' + ' ' + event
    }
}
