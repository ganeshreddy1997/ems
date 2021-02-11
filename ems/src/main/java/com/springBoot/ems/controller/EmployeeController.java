package com.springBoot.ems.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springBoot.ems.dao.EmployeeEntityRepository;
import com.springBoot.ems.entity.EmployeeEntity;
import com.springBoot.ems.model.EmployeeModel;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeEntityRepository dao;
	
	@GetMapping({ "/","/index"})
	public String indexPage() {
		return "index";
	}
	
	
	@PreAuthorize(value = "hasRole('ROLE_USER') && authentication.name=='GANESHS'")	
	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		EmployeeModel emp = new EmployeeModel();
		model.addAttribute("emp", emp);
		return "addEmployee";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute(name = "emp")EmployeeModel empModel, Model model) {
		EmployeeEntity e = new EmployeeEntity();
		BeanUtils.copyProperties(empModel, e);
		boolean flag = dao.existsById(e.getEmpNo());
		if(flag == true) {
			model.addAttribute("message", "Employee Number is exist");
		}else {
			dao.save(e);
			model.addAttribute("message", "Employee is saved");
		}
		return "index";
	}
	
	@GetMapping("/employeeList")
	public String employeeList(Model model){
		List<EmployeeEntity> empList = dao.findAll();
		List<EmployeeModel> empModelList = new ArrayList<>();
		empList.forEach(e-> {
			EmployeeModel empModel = new EmployeeModel();
			BeanUtils.copyProperties(e, empModel);
			empModelList.add(empModel);
		});
		model.addAttribute("empModelList", empModelList);
		return "employeeList";
	}
	
	@GetMapping("/editEmployee")
	public String editEmployee(@RequestParam("id") Integer empNo, Model model) {
		EmployeeEntity e = dao.findById(empNo).get();
		EmployeeModel eModel = new EmployeeModel();
		BeanUtils.copyProperties(e, eModel);
		model.addAttribute("editEmp", eModel);
		return "editEmployee";
	}
	
	@PostMapping("/updateEmployee")
	public String updateEmployee(@ModelAttribute EmployeeModel eModel) {
		EmployeeEntity e = new EmployeeEntity();
		BeanUtils.copyProperties(eModel, e);
		dao.saveAndFlush(e);
		return "redirect:employeeList";
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("id") Integer empNo) {
		dao.deleteById(empNo);
		return "redirect:employeeList";
	}
	
	@GetMapping("/loggedOut")
	public String logout() {
		return "loggedOut";
	}
}



















