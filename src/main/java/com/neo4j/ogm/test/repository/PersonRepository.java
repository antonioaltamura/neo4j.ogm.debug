package com.neo4j.ogm.test.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.neo4j.ogm.test.models.Person;

@Repository
public interface PersonRepository extends GraphRepository<Person> {

	List<Person> findAll();
	
	void deleteAll();

	@Query("MATCH (p:Person) DETACH DELETE p")
	void clear();

	@Query("MATCH (n:Person {name:{0}}) RETURN n")
	Person getPersonByName(String codice);
	
	Person getPersonByNodeid(String nodeid);

	@Query("MATCH (i:Person {nodeid:{0}), (a:Reato {nodeid:{1}}) CREATE (i)-[:AccusedOf]->(a)")
	void addImputazione(String nodeid, String reatoid);
}