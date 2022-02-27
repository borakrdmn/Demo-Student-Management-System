package com.project.studentMS.Business;

import java.util.List;


import com.project.studentMS.Entities.Teacher;


public interface ITeacherService {
	List<Teacher> getAll();
	void add(Teacher teacher);
	void update(Teacher teacher);
	void delete(Teacher teacher);
	Teacher getById(int id);
}
