package com.example.webapp.model.Repo;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.example.webapp.model.Model2;

@Transactional
public interface Repo extends CrudRepository<Model2, String>{

 
}
