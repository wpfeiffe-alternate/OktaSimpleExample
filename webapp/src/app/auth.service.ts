import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AuthUser} from './AuthUser';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private userIsAuthenticated: boolean = false;

  constructor(private httpClient: HttpClient) { }

  isAuthenticated(): Observable<AuthUser> {
    return this.httpClient.get<AuthUser>('http://localhost:8080/api/isauthenticated', {withCredentials: true});
    //return of(new AuthUser('fakeone'));
  }
}
