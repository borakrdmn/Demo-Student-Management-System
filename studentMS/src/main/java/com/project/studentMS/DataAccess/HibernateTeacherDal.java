package com.project.studentMS.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.studentMS.Entities.Teacher;

@Repository
public class HibernateTeacherDal implements ITeacherDal{
	private EntityManager entityManager;
	
	public HibernateTeacherDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Teacher> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Teacher> teachers = session.createQuery("from Teacher",Teacher.class).getResultList();
		return teachers;
	}

	@Override
	@Transactional
	public void add(Teacher teacher) {
		Session session = entityManager.unwrap(Session.class);
		session.save(teacher);
	}

	@Override
	@Transactional
	public void update(Teacher teacher) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(teacher);
	}

	@Override
	@Transactional
	public void delete(Teacher teacher) {
		Session session = entityManager.unwrap(Session.class);
		Teacher teacherToDelete = session.get(Teacher.class,teacher.getId());
		session.delete(teacherToDelete);
	}

	@Override
	@Transactional
	public Teacher getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Teacher teacher = session.get(Teacher.class,id);
		return teacher;
	}

}
