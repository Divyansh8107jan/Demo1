package com.practice5.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice5.dto.Practice5RegDTO;
import com.practice5.entity.Registration;
import com.practice5.exception.Practice5ResourseNotFoudException;
import com.practice5.repository.Practice5RegRepository;

@RestController
@RequestMapping("/practice5/api/registration")
public class Practice5RestRegController {
	
	@Autowired
	Practice5RegRepository practice5RegRepository;
	
	@GetMapping
	public List<Registration> getRegistration() {
		List<Registration> reg = practice5RegRepository.findAll();
		return reg;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRegById(@PathVariable long id) {
		Optional<Registration> byId = practice5RegRepository.findById(id);
		if(byId.isPresent()) {
			practice5RegRepository.deleteById(id);
		}else {
			throw new Practice5ResourseNotFoudException("Record is not found by id: " + id);
		}
		return new ResponseEntity<>("Record is deleted!!" , HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> saveRegistration(@Valid @RequestBody Registration registration , BindingResult result) {
		if(result.hasErrors()) {
			return new ResponseEntity<>(result.getFieldError().getDefaultMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Registration saveReg = practice5RegRepository.save(registration);
		return new ResponseEntity<>(saveReg , HttpStatus.CREATED);
	}
	
	
	@PutMapping
	public void updateRegistration(@RequestParam long id , @RequestBody Practice5RegDTO dto) {
		Registration registration = practice5RegRepository.findById(id).get();
		registration.setFirstName(dto.getFirstName());
		registration.setLastName(dto.getLastName());
		registration.setEmail(dto.getEmail());
		registration.setMobile(dto.getMobile());
		
		practice5RegRepository.save(registration);
	}

}
