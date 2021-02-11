package com.springBoot.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.springBoot.ems.entity.EmployeeEntity;

@Repository
public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, Integer> {
	
	

}