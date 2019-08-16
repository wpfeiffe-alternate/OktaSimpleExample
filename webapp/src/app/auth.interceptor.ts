import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {tap} from 'rxjs/operators';

// TODO: use this for withCredentials, doing this is cleaner
export class AuthInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req).pipe(
      tap(
        (event: HttpEvent<any>) => {
          if (event instanceof HttpResponse) {
            console.log('status = ' + event.status);
            const headerkeys: string [] = event.headers.keys();
            headerkeys.forEach( item => {
              console.log('header item: ' + item);
            });
          }
        }
      )
    );
  }

}
