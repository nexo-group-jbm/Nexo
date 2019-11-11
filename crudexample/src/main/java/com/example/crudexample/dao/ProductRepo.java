package com.example.crudexample.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.crudexample.model.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, String>{

}
