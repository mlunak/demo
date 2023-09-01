import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpEvent, HttpRequest, HttpHandler, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AppHttpInterceptor implements HttpInterceptor {
    intercept(httpRequest: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const headers = new HttpHeaders(
            {
                "funtoken": "fun",
                "funCallChainId": this.getCallChainId()
            }
        )
        return next.handle(httpRequest.clone({ headers: headers }));
    }

    private getCallChainId(): string {
        const a = Math.floor(Math.random() * 10_000);
        return `FFE${this.getTimeStampFormatted(new Date().toLocaleString("cs-CS").split(',')[0])}X${a.toString().padStart(5,"0")}`
    }

    private getTimeStampFormatted(locale: string): string {
        var daymon = locale.split(".")
        var day = daymon[0].trim().padStart(2, "0")
        var mon = daymon[1].trim().padStart(2, "0")
        var yeartime = daymon[2].trim().split(" ")
        var year = yeartime[0]
        var time = yeartime[1].replaceAll(":", "")
        return year + mon + day + time
    }
}