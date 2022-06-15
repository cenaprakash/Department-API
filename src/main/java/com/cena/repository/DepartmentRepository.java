package com.cena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cena.pojo.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>
{

	public Department findByDepartmentCode(String departmentCode);
}
