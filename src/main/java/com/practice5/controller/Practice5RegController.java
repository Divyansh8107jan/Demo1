package com.practice5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice5.dto.Practice5RegDTO;
import com.practice5.entity.Registration;
import com.practice5.service.Practice5RegService;

@Controller
public class Practice5RegController {

	@Autowired
	Practice5RegService practice5RegService;
	
	//http://localhost:8080/view_Reg_Page
	@RequestMapping("/view_Reg_Page")
	public String viewRegPage() {
		return "ViewRegistrationPage";
	}
	
//	@RequestMapping("/saveReg")
//	public String saveRegistration(Registration registration , ModelMap model) {
//		practice5RegService.saveRegistration(registration);
//		model.addAttribute("msg", "Record is saved!!");
//		return "ViewRegistrationPage";
//	}
	
	@RequestMapping("/saveReg")
	public String saveRegistration(Practice5RegDTO dto , ModelMap model) {
		Registration registration = new Registration();
		registration.setFirstName(dto.getFirstName());
		registration.setLastName(dto.getLastName());
		registration.setEmail(dto.getEmail());
		registration.setMobile(dto.getMobile());
		
		practice5RegService.saveRegistration(registration);
		model.addAttribute("msg", "Record is saved!!");
		return "ViewRegistrationPage";
	}
	
	
	//http://localhost:8080/getAllReg 
	@RequestMapping("/getAllReg")
	public String getAll(ModelMap model) {
		List<Registration> reg = practice5RegService.getAllReg();
		model.addAttribute("registration", reg);
		return "Practice5ListReg";
	}
	
	@RequestMapping("/delete")
	public String deleteregistration(@RequestParam("id") long id , ModelMap model) {
		practice5RegService.deleteRegById(id);
		List<Registration> reg = practice5RegService.getAllReg();
		model.addAttribute("registration", reg);
		return "Practice5ListReg";
	}
	
	@RequestMapping("/updateReg")
	public String getRegById(@RequestParam("id") long id , ModelMap model) {
		Registration registration = practice5RegService.getRegById(id);
		model.addAttribute("reg", registration);
		return "Practice5UpdateReg";
	}
	
	@RequestMapping("/updateRegistrationDetails")
	public String updateRegistration(Practice5RegDTO dto , ModelMap model) {
		Registration registration = new Registration();
		registration.setId(dto.getId());
		registration.setFirstName(dto.getFirstName());
		registration.setLastName(dto.getLastName());
		registration.setEmail(dto.getEmail());
		registration.setMobile(dto.getMobile());
		
		practice5RegService.saveRegistration(registration);
		
		List<Registration> reg = practice5RegService.getAllReg();
		model.addAttribute("registration", reg);
		return "Practice5ListReg";
	}
}
