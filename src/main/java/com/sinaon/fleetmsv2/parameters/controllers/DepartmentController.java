package com.sinaon.fleetmsv2.parameters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinaon.fleetmsv2.parameters.models.CommonObject;
import com.sinaon.fleetmsv2.parameters.services.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/departments")
	public String getAll(Model model) {

		List<CommonObject> departments = departmentService.getAll();
		model.addAttribute("departments", departments);
		return "parameters/departments";
	}

	@GetMapping("/departmentAdd")
	public String add() {
		return "parameters/departmentAdd";
	}

	@GetMapping("/departmentEdit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		CommonObject departments = departmentService.getById(id);
		model.addAttribute("departments", departments);
		return "parameters/departmentEdit";
	}

	@GetMapping("/departmentDetails/{id}")
	public String details(@PathVariable Integer id, Model model) {
		CommonObject departments = departmentService.getById(id);
		model.addAttribute("departments", departments);
		return "parameters/departmentDetails";
	}

	@PostMapping("/departments")
	public String save(CommonObject department) {
		departmentService.save(department);
		return "redirect:/countries";
	}

	@RequestMapping(value = "/departments/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delete(@PathVariable Integer id) {
		departmentService.delete(id);
		return "redirect:/departments";
	}

	@RequestMapping(value = "/departments/update/{id}", method = { RequestMethod.GET, RequestMethod.PUT })
	public String update(CommonObject departments) {
		departmentService.save(departments);
		return "redirect:/departments";
	}

}
