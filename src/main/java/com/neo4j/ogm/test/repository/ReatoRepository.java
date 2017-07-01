package com.neo4j.ogm.test.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.neo4j.ogm.test.models.Reato;


@Repository
public interface ReatoRepository extends GraphRepository<Reato> {

	List<Reato> findAll();
	
	@Query("MATCH (p:Reato) DETACH DELETE p")
	void clear();
	
	/*@Query("MATCH (m:Movie {title:\"The Matrix\"})<-[r:ACTED_IN]-(p:Person {name:\"Keanu Reeves\"}) RETURN p")
	List<Reato> getActedIn();
*/
	Reato getReatoByName(String codice);
	
	Reato getReatoByNodeid(String nodeid);


}