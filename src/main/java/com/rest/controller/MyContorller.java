package com.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyContorller {

	@RequestMapping("/user")
	public String hello() {
		return "Hello User";
	}
	@RequestMapping("/guest")
	public String helloGuest() {
		return "Hello Guest";
	}

	@RequestMapping("/admin")
	public String helloAdmin() {
		return "Hello Admin";
	}
	
	@RequestMapping("/all")
	public String helloAll() {
		return "Hello All";
	}

}
