package com.springBoot.ems.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class EmployeeEntity {
	
	@Id
	private Integer empNo;
	private String empName;
	private Double salary;
	private Integer deptNo;
	
	
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
}
