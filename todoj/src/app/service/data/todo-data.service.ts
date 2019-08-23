import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/Http';
import { Todo } from 'src/app/list-to-dos/list-to-dos.component';
import { API_URL, Todo_JPA_API_URL } from 'src/app/app-constants';

@Injectable({
  providedIn: 'root'
})
export class TodoDataService {

  
  constructor(private http:HttpClient) { }
  retrieveAllTodos(username) {
    //console.log("execute Hello World Bean Service");
    return this.http.get<Todo[]>(`${Todo_JPA_API_URL}/users/${username}/todos`);
    
  }
  deleteTodo(username,id) {
    return this.http.delete(`${Todo_JPA_API_URL}/users/${username}/todos/${id}`);
  }
  retrieveTodo(username,id) {
    return this.http.get<Todo>(`${Todo_JPA_API_URL}/users/${username}/todos/${id}`);
  }
  updateTodo(username,id,todo) {
    return this.http.put(`${Todo_JPA_API_URL}/users/${username}/todos/${id}`,todo);
  }
  createTodo(username,todo) {
    return this.http.post(`${Todo_JPA_API_URL}/users/${username}/todos`,todo);
  }
}
