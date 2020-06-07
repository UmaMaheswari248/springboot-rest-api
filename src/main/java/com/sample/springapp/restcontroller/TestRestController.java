package com.sample.springapp.restcontroller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestRestController {
	public static final Logger logger = LoggerFactory.getLogger(TestRestController.class.getName());
	String err="error occured";
	@RequestMapping("/test")
	public String testing() {
		try {
		logger.info("this is testing");
		return "testing GET method";
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.error("error is"+e.getMessage());
			return err;
		}
	}
	@RequestMapping("/get-json-response")
	public String get_json_response() {
		try {
		JSONObject json=new JSONObject();
		json.put("id", 1);
		json.put("Name", "Test-Name");
		logger.info(json.toString());
		return json.toString();
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.error("error is"+e.getMessage());
			return err;
		}
	}
	@RequestMapping("/get-params/{id}/{name}")
	public String get_params(@PathVariable("id") int id,@PathVariable("name") String name) {
		try {
		JSONObject json=new JSONObject();
		json.put("id", id);
		json.put("Name", name);
		logger.info("parameters"+id+""+name);
		return json.toString();
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return err;
			
		}
	}
	@RequestMapping(value="/post-request",method=RequestMethod.POST)
	public String get_params(@RequestBody String jsonString) {
		try {
		JSONObject json=new JSONObject(jsonString);	
		return json.toString();
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return err;
		}
	}
	
	@RequestMapping(value="/test-post",method=RequestMethod.POST)
	public String testing_post() {
		try {
		return "testing POST method";
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return err;
		}
	}
}
