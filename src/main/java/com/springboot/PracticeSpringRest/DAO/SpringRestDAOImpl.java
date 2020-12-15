package com.springboot.PracticeSpringRest.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.PracticeSpringRest.Entity.Admin;

@Repository
public class SpringRestDAOImpl implements SpringRestDAO {
	
	
	private EntityManager entityManager;
	

	@Autowired
	public SpringRestDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Admin> findAll() {
        Session session=entityManager.unwrap(Session.class);
        List<Admin> theAdmin=session.createQuery("from Admin", Admin.class).getResultList();
		return theAdmin;
	}

	@Override
	public Admin findById(int id) {
		 Session session=entityManager.unwrap(Session.class);
		 Admin theAdmin=session.get(Admin.class, id);
		return theAdmin;
	}

	@Override
	public void save(Admin theAdmin) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(theAdmin);

	}

	@Override
	public void deleteById(int id) {
		Session session=entityManager.unwrap(Session.class);
		Query theQuery=session.createQuery("delete from Admin where id=:adminId");
		theQuery.setParameter("adminId", id);
		theQuery.executeUpdate();
		
		

	}

}
