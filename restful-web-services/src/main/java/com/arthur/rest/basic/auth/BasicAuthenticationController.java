package com.arthur.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arthur.rest.webservices.restfulwebservices.helloworld.HelloWorldBean;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BasicAuthenticationController {

	
	@RequestMapping(method=RequestMethod.GET,path="/basicauth")
	public AuthenticationBean helloWorldBean() {
		//throw new RuntimeException("error happend");
		return new AuthenticationBean("You are authenticated");
	}

	
}
