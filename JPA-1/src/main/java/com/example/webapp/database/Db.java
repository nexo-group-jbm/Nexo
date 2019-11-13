package com.example.webapp.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.example.webapp.model.Jpamodel;
@Repository
public interface Db extends CrudRepository<Jpamodel, Integer>
{

}
