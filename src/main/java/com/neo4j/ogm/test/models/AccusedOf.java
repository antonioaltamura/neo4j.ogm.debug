package com.neo4j.ogm.test.models;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.Convert;

@RelationshipEntity(type = "AccusedOf")
public class AccusedOf implements Entity<AccusedOf>{

	@GraphId private Long id;
	@Property private String entityType, name, descrizione;
	public Long getId() {
		return id;
	}

    @StartNode
    Person source;

    @EndNode
    Reato target;
        
    public AccusedOf(){
    }
/*  BUG on neo4j-ogm 2.1 cannot set CompositeConverter class in RelationshipEntity
 * 
 * */
    @Convert(ObjPropConverter.class)
    private ArrayList<ObjProp> aggravanteCA;

	public AccusedOf setAggravante(ObjProp objProp) {
		this.aggravanteCA.add(objProp);
		return this;
	}
	public List<ObjProp> getAggravante() {
		return aggravanteCA;
	}  
	public AccusedOf setDescrizione(String descrizione) {
		this.descrizione = descrizione;
		return this;
	}
	public AccusedOf setSource(Person source) {
		this.source = source;
		return this;
	}
	public AccusedOf setTarget(Reato target) {
		this.target = target;
		return this;
	}
	public AccusedOf setEntity() {
		this.entityType = "AccusedOf";
		return this;
	}
	@Override
	public AccusedOf setId(Long id) {
		this.id = id;
		return this;
	}
	@Override
	public AccusedOf setName(String s) {
		this.name = s;
		return this;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public String getEntityType() {
		return this.entityType;
	}
	
}
