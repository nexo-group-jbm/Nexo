package com.project.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Customer;
@Repository
public interface CustomerDAO extends CrudRepository<Customer, Integer>{

}
