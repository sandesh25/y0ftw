package com.system.student.server;

import org.springframework.stereotype.Service;

import com.system.service.impl.ObjectServiceImpl;
import com.system.student.model.Student;
import com.system.student.service.StudentService;

@Service
public class StudentServiceImpl extends ObjectServiceImpl<Student> implements StudentService  {

	@Override
	public Class<Student> getObjectClass() {
		return Student.class;
	}
	
	@Override
	public Student add(Student newObject) {
		return super.add(newObject);
	}

	@Override
	public Student create(Student newObject) {
		return super.add(newObject);
	}
	
}
