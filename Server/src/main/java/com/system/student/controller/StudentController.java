package com.system.student.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.student.model.Student;
import com.system.student.service.StudentService;

@RestController
@RequestMapping("/StudentService")
public class StudentController {

	@Autowired
	StudentService studentService;

	static final Logger logger = Logger.getLogger(StudentController.class);

	@RequestMapping(value = "/create",  method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Student addEmployee(@RequestBody Student student) {
		return studentService.create(student);
	}

	@RequestMapping(value="/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Student getShopInJSON(@PathVariable String name) {
 
		Student student = new Student();
		student.setFirstname("aslkgh");
		student.setLastname("askg");
		student.setEmail("asgg");
		return student;
 
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Student login(@PathVariable String name) {
 
		Student student = new Student();
		student.setFirstname("aslkgh");
		student.setLastname("askg");
		student.setEmail("asgg");
		return student;
 
	}
}
