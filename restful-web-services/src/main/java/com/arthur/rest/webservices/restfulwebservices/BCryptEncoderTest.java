package com.arthur.rest.webservices.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		for(int i=1;i<10;i++) {
			String encodedString=encoder.encode("password@!123@#!");
			System.out.println(encodedString);
		}

	}

}
