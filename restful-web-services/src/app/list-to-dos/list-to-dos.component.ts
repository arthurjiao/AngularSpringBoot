import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { Router } from '@angular/router';
export class Todo {
  constructor(public id:number,
    public lastname:string,
    public firstname:string,
    public gender:string,
    public course:string,
    public done:boolean,
    public birthDay:Date
    ) {}
}
@Component({
  selector: 'app-list-to-dos',
  templateUrl: './list-to-dos.component.html',
  styleUrls: ['./list-to-dos.component.css']
})

export class ListToDosComponent implements OnInit {
  todos:Todo[]
  message:string

  constructor(private todoService:TodoDataService,
  private router:Router  ) { }

  ngOnInit() {
    this.refreshTodos();
  }
  refreshTodos() {
    this.todoService.retrieveAllTodos('arthur').subscribe(
      response=>{
        console.log(response);
        this.todos=response;}
    );
  }
  deleteTodo(id) {
    console.log(`delete ${id}`);
  
  this.todoService.deleteTodo('arthur',id).subscribe(
    response=>{
      console.log(response);
      this.message=`delete todo ${id}`;
      this.refreshTodos();
    }
  );
  }
  updateTodo(id) {
    console.log(`update ${id}`);
    this.router.navigate(['todos',id]);

  }
  addTodo() {
    //console.log(`update ${id}`);
    this.router.navigate(['todos',-1]);

  }
}
