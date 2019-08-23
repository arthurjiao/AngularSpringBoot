package com.arthur.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.arthur.rest.webservices.restfulwebservices.todo.Todo;
import com.arthur.rest.webservices.restfulwebservices.todo.TodoHardcodedService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoJPAResources {
	@Autowired
	private TodoHardcodedService todoService;
	@Autowired
	private TodoJpaRepository todoJpaRepository;
	@GetMapping("/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		return todoJpaRepository.findByFirstname(username);
		//return todoService.findAll();
	}
	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username,@PathVariable long id) {
		todoJpaRepository.deleteById(id);
		
			return ResponseEntity.noContent().build();
		
	}
	@GetMapping("/jpa/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username,@PathVariable long id) {

		 Todo t=new Todo((long) -1, "Jiao", username, "New Course", "Male", new Date(),false);
		
		if (id==-1) {
			return t;
			}
		return todoJpaRepository.findById(id).get();
		//return todoService.findById(id);
	}
	
	@PutMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username,
			@PathVariable long id,@RequestBody Todo todo) {
		Todo updateTodo=todoJpaRepository.save(todo);
	
		return new ResponseEntity<Todo>(todo,HttpStatus.OK);
	}
	@PostMapping("/jpa/users/{username}/todos")
	public ResponseEntity<Todo> createTodo(@PathVariable String username,@RequestBody Todo todo) {
		Todo createdTodo=todoJpaRepository.save(todo);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(createdTodo.getId()).toUri();
	
		return ResponseEntity.created(uri).build();
	}

	
}
