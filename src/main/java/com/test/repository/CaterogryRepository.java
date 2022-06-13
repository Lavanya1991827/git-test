package com.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Category;


public interface CaterogryRepository extends CrudRepository<Category, Integer>{

}
