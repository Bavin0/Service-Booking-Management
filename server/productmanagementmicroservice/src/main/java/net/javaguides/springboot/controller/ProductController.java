package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.repository.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/product")
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	// create employee rest api
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	// update employee rest api
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

		product.setName(productDetails.getName());
		product.setMake(productDetails.getMake());
		product.setModel(productDetails.getModel());
		product.setCost(productDetails.getCost());
		product.setCreatedDate(productDetails.getCreatedDate());

		Product updatedProduct= productRepository.save(product);
		return ResponseEntity.ok(updatedProduct);
	}
	
	// delete employee rest api
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id){
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

		productRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
