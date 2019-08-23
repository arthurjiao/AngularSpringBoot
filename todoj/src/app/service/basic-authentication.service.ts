import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import {map} from 'rxjs/operators';
import { API_URL, Todo_JPA_API_URL } from '../app-constants';
export const TOKEN = 'token'
export const AUTHENTICATED_USER = 'authenticaterUser'

@Injectable({
  providedIn: 'root'
})
export class BasicAuthenticationService {

  constructor(private http:HttpClient) { }
  executeJWTBasicAuthenticationBeanService(username,password) {
    //console.log("execute Hello World Bean Service");


      return this.http.post<any>(
        `${API_URL}/authenticate`,
        {username,password}).pipe(
          map(
            data => {
              sessionStorage.setItem(AUTHENTICATED_USER, username);
              sessionStorage.setItem(TOKEN, `Bearer ${data.token}`);
              return data;
            }
          )
        );
  

  }

  getAuthenticatedUser() {
    return  sessionStorage.getItem('authenticaterUser');
    //return !(user===null);
  }
  getAuthenticatedToken() {
    if (this.getAuthenticatedUser())
    return  sessionStorage.getItem('token');
    //return !(user===null);
  }
  isUserLoggedIn() {
    let user=sessionStorage.getItem('authenticaterUser');
    return !(user===null);
  }
  logout() {
    sessionStorage.removeItem('authenticaterUser');
    sessionStorage.removeItem('token');
    
  }
  executeBasicAuthenticationBeanService(username,password) {
    //console.log("execute Hello World Bean Service");

    let basicAuthHeaderString = 'Basic ' + window.btoa(username + ':' + password);

    let headers = new HttpHeaders({
        Authorization: basicAuthHeaderString
      })
      return this.http.get<AuthenticationBean>(
        `${API_URL}/basicauth`,
        {headers}).pipe(
          map(
            data => {
              sessionStorage.setItem(AUTHENTICATED_USER, username);
              sessionStorage.setItem(TOKEN, basicAuthHeaderString);
              return data;
            }
          )
        );
  

  }
  
}
export class AuthenticationBean {
  constructor(public message:string) {}
}
