package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test.entity.Category;
import com.test.repository.CaterogryRepository;

@SpringBootApplication
public class SpringBootJpaApplication  implements CommandLineRunner{
	Logger logger = LoggerFactory.getLogger(SpringBootJpaApplication.class); 

	 @Autowired 
	  private CaterogryRepository caterogryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//save()
		/*
		 * Category c= new Category(); c.setCategoryName("Vegetables");
		 * caterogryRepository.save(c);
		 */
		//saeAll
		/*
		 * List<Category> categoryList =new ArrayList<Category>(); Category c1= new
		 * Category(); c1.setCategoryName("test1"); Category c2= new Category();
		 * c2.setCategoryName("test2"); categoryList.add(c1); categoryList.add(c2);
		 * caterogryRepository.saveAll(categoryList);
		 */
		
		
		//findById
		/*
		 * Optional<Category> optional = caterogryRepository.findById(1); if
		 * (optional.isPresent()) { System.out.println(optional.get()); } else {
		 * System.out.printf("No employee found with id %d%n", 1); }
		 */
		
		//findAll
		List<Integer> categoryIdsList =new ArrayList<Integer>();
		List<Integer> categoryIdsDeleteList =new ArrayList<Integer>();
		  Iterable<Category> caterogyItr = caterogryRepository.findAll();
		  for(Category category : caterogyItr) {
		 logger.info("1category ID :" +category.getCategoryId() +":: category name:"+category.getCategoryName());
		 if(category.getCategoryId()==3 || category.getCategoryId() ==4) {
			 categoryIdsDeleteList.add(category.getCategoryId());
		 }else {
			 categoryIdsList.add(category.getCategoryId());
		 }
		 }
		  logger.info("categoryIdsList size:"+categoryIdsList.size());
		  logger.info("categoryIdsDeleteList size:"+categoryIdsDeleteList.size());
		  
		//findAllById
		Iterable<Category> categorysList = caterogryRepository.findAllById(categoryIdsList);
		for(Category c : categorysList) {
			logger.info("2category ID :" +c.getCategoryId() +":: category name:"+c.getCategoryName());
			  logger.info("categoryIdsDeleteList size:"+categoryIdsDeleteList.size());
		}
		
		//deleteAllById
		//caterogryRepository.deleteAllById(categoryIdsDeleteList);
		logger.info("final count of entries:"+caterogryRepository.count());
	}

}
