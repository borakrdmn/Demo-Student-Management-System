package com.project.studentMS.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.studentMS.DataAccess.IStudentDal;
import com.project.studentMS.Entities.Student;

@Service
public class StudentManager implements IStudentService{

	private IStudentDal studentDal;

	
	@Autowired
	public StudentManager(IStudentDal studentDal) {
		this.studentDal = studentDal;
	}

	@Override
	@Transactional
	public List<Student> getAll() {
		return this.studentDal.getAll();
	}

	@Override
	@Transactional
	public void add(Student student) {
		studentDal.add(student);
	}

	@Override
	@Transactional
	public void update(Student student) {
		studentDal.update(student);
	}

	@Override
	@Transactional
	public void delete(Student student) {
		studentDal.delete(student);
	}

	@Override
	@Transactional
	public Student getById(int id) {
		return studentDal.getById(id);
	}
}
