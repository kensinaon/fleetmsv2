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

import com.sinaon.fleetmsv2.parameters.models.Module;
import com.sinaon.fleetmsv2.parameters.services.ModuleService;

@Controller
public class ModuleController {

	@Autowired
	private ModuleService moduleService;

	@GetMapping("/modules")
	public String getAll(Model model) {

		List<Module> modules = moduleService.getAll();
		model.addAttribute("modules", modules);
		return "parameters/modules";
	}

	@GetMapping("/moduleAdd")
	public String add() {
		return "parameters/moduleAdd";
	}

	@GetMapping("/moduleEdit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Module modules = moduleService.getById(id);
		model.addAttribute("modules", modules);
		return "parameters/moduleEdit";
	}

	@GetMapping("/moduleDetails/{id}")
	public String details(@PathVariable Integer id, Model model) {
		Module modules = moduleService.getById(id);
		model.addAttribute("modules", modules);
		return "parameters/moduleDetails";
	}

	@PostMapping("/modules")
	public String save(Module module) {
		moduleService.save(module);
		return "redirect:/modules";
	}

	@RequestMapping(value = "/modules/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public String delete(@PathVariable Integer id) {
		moduleService.delete(id);
		return "redirect:/modules";
	}

	@RequestMapping(value = "/modules/update/{id}", method = { RequestMethod.GET, RequestMethod.PUT })
	public String update(Module module) {
		moduleService.save(module);
		return "redirect:/modules";
	}

}
