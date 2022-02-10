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

import com.sinaon.fleetmsv2.parameters.models.Supplier;
import com.sinaon.fleetmsv2.parameters.services.SupplierService;

@Controller
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@GetMapping("/suppliers")
	public String getAll(Model model) {

		List<Supplier> suppliers = supplierService.getAll();
		model.addAttribute("suppliers", suppliers);
		return "parameters/suppliers";
	}

	@GetMapping("/supplierAdd")
	public String add() {
		return "parameters/supplierAdd";
	}

	@GetMapping("/supplierEdit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Supplier suppliers = supplierService.getById(id);
		model.addAttribute("suppliers", suppliers);
		return "parameters/supplierEdit";
	}

	@GetMapping("/supplierDetails/{id}")
	public String details(@PathVariable Integer id, Model model) {
		Supplier suppliers = supplierService.getById(id);
		model.addAttribute("suppliers", suppliers);
		return "parameters/supplierDetails";
	}

	@PostMapping("/suppliers")
	public String save(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/suppliers";
	}

	@RequestMapping(value = "/suppliers/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delete(@PathVariable Integer id) {
		supplierService.delete(id);
		return "redirect:/suppliers";
	}

	@RequestMapping(value = "/suppliers/update/{id}", method = { RequestMethod.GET, RequestMethod.PUT })
	public String update(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/suppliers";
	}

}
