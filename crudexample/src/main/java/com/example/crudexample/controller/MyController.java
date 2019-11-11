package com.example.crudexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudexample.dao.ProductRepo;
import com.example.crudexample.exceptions.ProductNotfoundException;
import com.example.crudexample.model.Product;
@RestController
public class MyController {
	@Autowired
	ProductRepo productrepo;
	   
	   @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	   public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
		   productrepo.deleteById(id);
	      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
	   public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) { 
		   if(!productrepo.existsById(id))
		   {
			   throw new ProductNotfoundException();
		   }
		   productrepo.save(product);
	      return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/product", method = RequestMethod.POST)
	   public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		   productrepo.save(product);
	      return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	   }
	   
	   @RequestMapping(value = "/product")
	   public Iterable<Product> getProduct() {
	      return productrepo.findAll();
	   }
}
