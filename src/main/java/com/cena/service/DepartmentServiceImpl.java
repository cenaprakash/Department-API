package com.cena.service;

import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cena.exceptionhandler.DepartmentNotFoundException;
import com.cena.pojo.Department;
import com.cena.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Override
	public Department saveDepartment(Department department) {		
		LOGGER.info("Inside Save Department Repository !");

		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getAllDepartment() {
		LOGGER.info("Inside Get ALL Department Repository !");
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartment(Long id) throws DepartmentNotFoundException {
		LOGGER.info("Inside Get Department Repository !");
		
		
		if(!departmentRepository.findById(id).isPresent())
			throw new DepartmentNotFoundException();

		return departmentRepository.findById(id).get();
	}

	@Override
	public String deleteDepartment(Long id) {
		LOGGER.info("Inside Delete Department Repository !");
		departmentRepository.deleteById(id);	
		return "Deletion Success";

	}

	@Override
	public void updateDepartment(Long id, Department department) {
		LOGGER.info("Inside Update Department Repository !");

		Department departmentDb = departmentRepository.findById(id).get();

		if(Objects.nonNull(department.getDepartmentName() ) && !"".equalsIgnoreCase(department.getDepartmentName())) {

			departmentDb.setDepartmentName(department.getDepartmentName());

		}

		if(Objects.nonNull(department.getDepartmentCode() ) && !"".equalsIgnoreCase(department.getDepartmentCode())) {

			departmentDb.setDepartmentCode(department.getDepartmentCode());

		}

		if(Objects.nonNull(department.getDepartmentLocation() ) && !"".equalsIgnoreCase(department.getDepartmentLocation())) {

			departmentDb.setDepartmentLocation(department.getDepartmentLocation());

		}

		departmentRepository.save(departmentDb);

	}

	@Override
	public Department findByDepartmentCode(String departmentCode) {
		return departmentRepository.findByDepartmentCode(departmentCode);
	}

}
