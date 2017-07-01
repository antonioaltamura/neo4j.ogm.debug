package com.neo4j.ogm.test.models;


import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Reato implements Entity<Reato> {

	@GraphId private Long id;

	@Property private String nodeid,entityType,name;
	
	public Reato setId(Long id) {
		this.id = id;
		return this;
	}

	public Reato setName(String name) {
		this.name = name;
		return this;
	}

	public Reato setNodeid(String string) {
		this.nodeid = string;
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

	public Reato setType() {
		this.entityType = "Reato";
		return this;
	}

	@Override
	public String getEntityType() {
		return this.entityType;
	}
	

}