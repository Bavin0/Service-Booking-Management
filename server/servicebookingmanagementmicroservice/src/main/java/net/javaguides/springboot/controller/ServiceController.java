package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.model.Services;
import net.javaguides.springboot.repository.ServiceRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ServiceController {

	@Autowired
	private ServiceRepository serviceRepository;

	@GetMapping("/services")
	public List<Services> getServices(){
		return serviceRepository.findAll();
	}
	
	// create employee rest api
	@PostMapping("/services")
	public Services addService(@RequestBody Services services) {
		return serviceRepository.save(services);
	}
	
	// update employee rest api
	
	@PutMapping("/services/{id}")
	public ResponseEntity<Services> updateService(@PathVariable Long id, @RequestBody Services serviceDetails){
		Services services = serviceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

		services.setProductId(serviceDetails.getProductId());
		services.setUserId(serviceDetails.getUserId());
		services.setReqDate(serviceDetails.getReqDate());
		services.setProblem(serviceDetails.getProblem());
		services.setDescription(serviceDetails.getDescription());
		services.setStatus(serviceDetails.getStatus());

		Services updatedService= serviceRepository.save(services);
		return ResponseEntity.ok(updatedService);
	}
	

	@DeleteMapping("/services/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteService(@PathVariable Long id){
		Services services = serviceRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

		serviceRepository.delete(services);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
