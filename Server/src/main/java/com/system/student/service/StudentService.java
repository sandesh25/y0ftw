package com.system.student.service;

import org.springframework.stereotype.Component;

import com.system.service.ObjectService;
import com.system.student.model.Student;

@Component("studentService")
public interface StudentService extends ObjectService<Student> {

	Student create(Student newObject);

}
