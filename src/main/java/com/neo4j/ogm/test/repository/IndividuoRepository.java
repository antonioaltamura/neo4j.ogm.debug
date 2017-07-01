package com.neo4j.ogm.test.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.neo4j.ogm.test.models.Person;

@Repository
public interface IndividuoRepository extends GraphRepository<Person> {

	List<Person> findAll();
	
	void deleteAll();

	@Query("MATCH (p:Individuo) DETACH DELETE p")
	void clear();

	@Query("MATCH (n:Individuo {name:{0}}) RETURN n")
	Person getIndividuoByName(String codice);
	
	Person getIndividuoByNodeid(String nodeid);

	//mancano aggravanti/attenuanti usare HaPrecedente e ImputatoDi class
	@Query("MATCH (i:Individuo {nodeid:{0}), (a:Reato {nodeid:{1}}) CREATE (i)-[:ImputatoDi]->(a)")
	void addImputazione(String nodeid, String reatoid);
	
	@Query("MATCH (n:Individuo)-[r]->() RETURN n, count(r) AS degree")
	Person getIndividuoDegree();

	@Query("MATCH (node:Individuo) WITH collect(node) AS nodes  CALL apoc.algo.closeness(['TYPE'],nodes,'INCOMING') YIELD node, score RETURN { Name: node.name , Born: node.born, score:score} as Individuo ORDER BY score DESC")
	Iterable<Map<String, String>> getCloseness();

	@Query("match (n:Individuo), (m:Individuo)"+
			"where n <> m "+
			"with n, m "+
			"match p=shortestPath((n)-[*]->(m)) "+
			"return length(p) "+
			"order by length(p) desc limit 1")
	int getDiameter();

	@Query("MATCH (s) WHERE ID(s) = {0} RETURN s")
	Iterable<Map<String, String>> getNode(Long id);

	@Query("MATCH (p1:Individuo) -[:ImputatoDi]->(m:Reato)<-[:ImputatoDi]-(p2:Individuo) "+ 
			" WHERE p1 <> p2 "+
			" CALL apoc.create.vRelationship(p1,'compagnoDireato',{name:'compagnoDireato'},p2) YIELD rel as vr "+ 
			" RETURN p1,p2,vr")
	Iterable<Map<String, String>> getProj();

}