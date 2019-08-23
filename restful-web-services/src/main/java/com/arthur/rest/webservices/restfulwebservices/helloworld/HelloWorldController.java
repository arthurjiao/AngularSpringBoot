package com.arthur.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arthur.rest.webservices.restfulwebservices.helloworld.HelloWorldBean;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class HelloWorldController {
	@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	public String helloWorld() {
		return "hello world";
	}
	@RequestMapping(method=RequestMethod.GET,path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		//throw new RuntimeException("error happend");
		return new HelloWorldBean("hello world");
	}
	@GetMapping(path="/hello-world-bean/pathvariable/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		//throw new RuntimeException("error happend");
		return new HelloWorldBean(String.format("Welcome to 99 Art Studio %s, have a good art experience.",name));
	}
}
