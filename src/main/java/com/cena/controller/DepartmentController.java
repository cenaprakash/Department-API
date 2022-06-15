package com.cena.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cena.exceptionhandler.DepartmentNotFoundException;
import com.cena.pojo.Department;
import com.cena.service.DepartmentService;

@RestController()
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@Value("${welcome}")
	private String welcomeMessage;

	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department) {	
		
		LOGGER.info(welcomeMessage);
		LOGGER.info("Inside saveDepartment of DepartmentController");
		return departmentService.saveDepartment(department);

	}
	
	@GetMapping("/departments/welcome")
	public String getMessage() {	
		
		System.out.println("Hi ");

		return welcomeMessage;

	}


	@GetMapping("/departments")
	public List<Department> getAllDepartments() {		

		return departmentService.getAllDepartment();

	}

	@GetMapping("/departments/{id:^[1-9]*}")
	public Department getDepartment(@PathVariable("id") Long id) throws DepartmentNotFoundException {		
		LOGGER.info("Inside getDepartment of DepartmentController");

		return departmentService.getDepartment(id);

	}


	
	  @GetMapping("/departments/code/{departmentCode}") public Department
	  getDepartmentByCode(@PathVariable("departmentCode") String departmentCode) {
	  LOGGER.info("Inside getDepartmentByCode of DepartmentController");
	  
	  return departmentService.findByDepartmentCode(departmentCode);
	  
	  }
	 
	@DeleteMapping("/departments/{id}")
	public String deleteDepartment(@PathVariable("id") Long id) {		
		LOGGER.info("Inside deleteDepartment of DepartmentController");

		return departmentService.deleteDepartment(id);

	}

	@PutMapping("/departments/{id}")
	public String updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
		LOGGER.info("Inside updateDepartment of DepartmentController");


		departmentService.updateDepartment(id,department);

		return "Updation Succeeded! ";


	}



}
