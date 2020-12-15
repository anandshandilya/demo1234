package com.springboot.PracticeSpringRest.DAO;

import java.util.List;

import com.springboot.PracticeSpringRest.Entity.Admin;

public interface SpringRestDAO {

	public List<Admin> findAll();
	public Admin findById(int id);
	public void save(Admin theAdmin);
	public void deleteById(int id);
}
