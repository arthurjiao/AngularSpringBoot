import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { Todo } from '../list-to-dos/list-to-dos.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

 id:number
 todo:Todo
  constructor(
    private todoService:TodoDataService,
    private route:ActivatedRoute,
    private router:Router
  ) { }
/*public id:number,
public lastname:string,
public firstname:string,
public gender:string,
public course:string,
public done:boolean,
public targetDate:Date*/
  ngOnInit() {
    this.todo=new Todo(this.id,'lastname','firstname','gender','course',false,new Date());
    if (this.id!=-1) {
    this.id=this.route.snapshot.params['id'];
    this.todoService.retrieveTodo('arthur',this.id).subscribe(
      data=>this.todo=data
    );
  }
  }
  saveTodo() {
    if(this.id == -1) { //=== ==
      this.todoService.createTodo('arthur', this.todo)
          .subscribe (
            data => {
              console.log(data)
              this.router.navigate(['todos'])
            }
          )
    } else {
      this.todoService.updateTodo('arthur', this.id, this.todo)
          .subscribe (
            data => {
              console.log(data)
              this.router.navigate(['todos'])
            }
          )
    }
  }

}
