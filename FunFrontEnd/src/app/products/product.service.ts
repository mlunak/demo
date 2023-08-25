import { Injectable } from "@angular/core";
import { IProduct } from "./product";
import { HttpClient, HttpHeaders, HttpErrorResponse } from "@angular/common/http"
import { Observable, catchError, tap, throwError } from "rxjs";
import { ValuableResponse } from "./valuable-response";
import { environment } from "environment"

@Injectable({
    providedIn: "root"
})
export class ProductService {
    private productUrl = `${environment.backEndURL}/fun/v2`

    constructor(private httpClientService: HttpClient) { }

    getProducts(): Observable<ValuableResponse> {
        const headers = new HttpHeaders(
            {   
                "funtoken": "fun"
            }
        )
        return this.httpClientService.get<ValuableResponse>(this.productUrl, { "headers": headers }).pipe(
            tap(data => console.log("The response: " + JSON.stringify(data))),
            catchError(this.handleError)
        )
    }

    private handleError(err: HttpErrorResponse): Observable<never> {
        // in a real world app, we may send the server to some remote logging infrastructure
        // instead of just logging it to the console
        let errorMessage = '';
        if (err.error instanceof ErrorEvent) {
            // A client-side or network error occurred. Handle it accordingly.
            errorMessage = `An error occurred: ${err.error.message}`;
        } else {
            // The backend returned an unsuccessful response code.
            // The response body may contain clues as to what went wrong,
            errorMessage = `Server returned code: ${err.status}, error message is: ${err.message}`;
        }
        console.error(errorMessage);
        return throwError(() => errorMessage);
    }
}