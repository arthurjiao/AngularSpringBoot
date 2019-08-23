package com.arthur.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class TodoHardcodedService {
	private static List<Todo> todos=new ArrayList<>();
	private static long idCounter=0;
//	static {
//		todos.add(new Todo(++idCounter,"arthur","learn java",new Date(),false));
//		todos.add(new Todo(++idCounter,"arthur","learn Angular JS",new Date(),false));
//		todos.add(new Todo(++idCounter,"arthur","learn Deep Learning",new Date(),false));
//	}
	public List<Todo> findAll() {
		return todos;
	}
	public Todo deleteById(long id) {
		Todo todo=findById(id);
		if(todo==null) {return null;}
		if (todos.remove(todo)) return todo;
		return null;
	}
	public Todo findById(long id) {
		// TODO Auto-generated method stub
		if (id==-1) {
//			return new Todo((long) -1,"empty","empty",new Date(),false);
			}
		for(Todo todo:todos) {
			if(todo.getId()==id) return todo;
		}
		return null;
	}
	public Todo save(Todo todo) {
		// TODO Auto-generated method stub
		
			if(todo.getId()==-1||todo.getId()==0) {
				todo.setId(++idCounter);
				todos.add(todo);} 
			else {
				deleteById(todo.getId());
				todos.add(todo);
			}
		
		return todo;
	}
}
