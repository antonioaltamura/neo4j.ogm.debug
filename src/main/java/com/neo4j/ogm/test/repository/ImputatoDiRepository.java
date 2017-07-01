package com.neo4j.ogm.test.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.neo4j.ogm.test.models.AccusedOf;
import com.neo4j.ogm.test.models.Person;


public interface ImputatoDiRepository extends GraphRepository<Person> {
	
	@Query("match ()-[i:ImputatoDi]-() DELETE i")
	void clear();
	
	@Query("match ()-[i:ImputatoDi]-() return i")
	List<AccusedOf> getAll();
	
	void save(AccusedOf s);
	
	
}
