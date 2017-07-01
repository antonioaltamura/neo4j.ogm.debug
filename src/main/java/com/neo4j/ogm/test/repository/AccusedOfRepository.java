package com.neo4j.ogm.test.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.neo4j.ogm.test.models.AccusedOf;
import com.neo4j.ogm.test.models.Person;


public interface AccusedOfRepository extends GraphRepository<Person> {
	
	@Query("match ()-[i:AccusedOf]-() DELETE i")
	void clear();
	
	@Query("match ()-[i:AccusedOf]-() return i")
	List<AccusedOf> getAll();
	
	void save(AccusedOf s);
	
	
}
