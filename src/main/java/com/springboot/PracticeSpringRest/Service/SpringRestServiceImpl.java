package com.springboot.PracticeSpringRest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.PracticeSpringRest.DAO.SpringRestDAO;
import com.springboot.PracticeSpringRest.Entity.Admin;

@Service
public class SpringRestServiceImpl implements SpringRestService {

	@Autowired
	private SpringRestDAO springDAO;
	
	@Override
	@Transactional
	public List<Admin> findAll() {
		List<Admin> theAdmin=springDAO.findAll();
		return theAdmin;
	}

	@Override
	@Transactional
	public Admin findById(int id) {
		
		return springDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Admin theAdmin) {
		springDAO.save(theAdmin);
		}

	@Override
	@Transactional
	public void deleteById(int id) {
		springDAO.deleteById(id);

	}

}
