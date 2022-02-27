package com.project.studentMS.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.studentMS.DataAccess.ITeacherDal;
import com.project.studentMS.Entities.Teacher;
@Service
public class TeacherManager implements ITeacherService{

private ITeacherDal teacherDal;

	
	@Autowired
	public TeacherManager(ITeacherDal teacherDal) {
		this.teacherDal = teacherDal;
	}

	@Override
	@Transactional
	public List<Teacher> getAll() {
		return this.teacherDal.getAll();
	}

	@Override
	@Transactional
	public void add(Teacher teacher) {
		teacherDal.add(teacher);
	}

	@Override
	@Transactional
	public void update(Teacher teacher) {
		teacherDal.update(teacher);
	}

	@Override
	@Transactional
	public void delete(Teacher teacher) {
		teacherDal.delete(teacher);
	}

	@Override
	@Transactional
	public Teacher getById(int id) {
		return teacherDal.getById(id);
	}
}
