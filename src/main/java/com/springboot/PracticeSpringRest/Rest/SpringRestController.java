package com.springboot.PracticeSpringRest.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.PracticeSpringRest.Entity.Admin;
import com.springboot.PracticeSpringRest.Service.SpringRestService;

@RestController
@RequestMapping("/api")
public class SpringRestController {

	@Autowired
	public SpringRestService springRestService;	
	
	@GetMapping("/admins")
	public List<Admin> findAll(){
		return springRestService.findAll();
	}
	
	@GetMapping("/admins/{adminId}")
	public Admin findById(@PathVariable int adminId) {
		Admin tempAdmin =springRestService.findById(adminId);
		if (tempAdmin== null) {
			throw new RuntimeException("Admin not exist with ID : "+ adminId);
		}
		return tempAdmin;
	}
	
	@PostMapping("/admins")
	public Admin addAdmin(@RequestBody Admin theAdmin) {
		theAdmin.setId(0);
		springRestService.save(theAdmin);
		return theAdmin;
		
	}
	
	@PutMapping("/admins")
	public Admin updateAdmin(@RequestBody Admin theAdmin) {
		springRestService.save(theAdmin);
		return theAdmin;
		
	}
	
	@DeleteMapping("/admins/{adminId}")
	public String deleteAdmin(@PathVariable int adminId) {
		Admin tempAdmin =springRestService.findById(adminId);
		if (tempAdmin== null) {
			throw new RuntimeException("Admin not exist with ID : "+ adminId);
		}
		springRestService.deleteById(adminId);
		return "Deleted the Admin with ID : "+adminId;
		
	}
}
