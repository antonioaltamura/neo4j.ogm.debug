package com.neo4j.ogm.test.models;
import java.util.List;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NodeEntity
public class Person implements Entity<Person>{

	@GraphId private Long id;
	@Property private String
					nodeid,
					entityType,
					name;
	@Relationship(type = "AccusedOf", direction = Relationship.UNDIRECTED)
	public List<AccusedOf> imp;
	public Person setId(Long id) {
		this.id = id;
		return this;
	}
	public Person setNodeid(String string) {
		this.nodeid = string;
		return this;
	}
	public Person setName(String name) {
		this.name = name;
		return this;
	}
	public Long getId() {
		return id;
	}
	public String getNodeid() {
		return nodeid;
	}
	public String getName() {
		return name;
	}
	public String toString(){
		return "("+this.nodeid +", "+ this.name + ")" ;	
	}
	@Override
	public String getEntityType() {
		return this.entityType;
	}
	public Person setEntityType() {
		this.entityType = "AccusedOf";
		return this;
	}
}