package com.practice5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice5.entity.Registration;
import com.practice5.repository.Practice5RegRepository;

@Service
public class Practice5RegService {
	
	@Autowired
	private Practice5RegRepository practice5RegRepository;
	
	public void saveRegistration(Registration registration) {
		practice5RegRepository.save(registration);
	}
	
	public List<Registration> getAllReg(){
		List<Registration> reg = practice5RegRepository.findAll();
		return reg;
	}
	
	public void deleteRegById(long id) {
		practice5RegRepository.deleteById(id);
	}
	
	
	public Registration getRegById(long id) {
		Registration reg = practice5RegRepository.findById(id).get();
		return reg;
	}

}
