package com.demo.app.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.app.Configuration;

@RestController
public class DemoController {

	@Autowired
	private Configuration configuartion;
	
	@RequestMapping(value="/getName", method=RequestMethod.GET)
	public String getName() {
		return "My Name is " + configuartion.getName();
	}
	
}
