package com.project.studentMS.Business;

import java.util.List;

import com.project.studentMS.Entities.Student;

public interface IStudentService {
	List<Student> getAll();
	void add(Student student);
	void update(Student student);
	void delete(Student student);
	Student getById(int id);
}
