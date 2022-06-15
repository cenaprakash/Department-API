package com.cena.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cena.exceptionhandler.DepartmentNotFoundException;
import com.cena.pojo.Department;


public interface DepartmentService {
	
public Department saveDepartment(Department department);

public List<Department> getAllDepartment();

public Department getDepartment(Long id) throws DepartmentNotFoundException;

public String deleteDepartment(Long id);

public void updateDepartment(Long id, Department department);

public Department findByDepartmentCode(String departmentCode);

}
