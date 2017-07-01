package com.neo4j.ogm.test.models;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.Convert;

@RelationshipEntity(type = "ImputatoDi")
public class AccusedOf implements Entity<AccusedOf>{

	@GraphId private Long id;
	@Property private String sourceid,targetid;
	@Property private String entityType, name, edgeid, descrizione, reato;
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
    private ObjProp aggravanteCA;

	public AccusedOf setAggravante(ObjProp objProp) {
		this.aggravanteCA = objProp;
		return this;
	}
	public ObjProp getAggravante() {
		return aggravanteCA;
	}  

	public AccusedOf setEdgeid(String edgeid) {
		this.edgeid = edgeid;
		return this;
	}

	public AccusedOf setDescrizione(String descrizione) {
		this.descrizione = descrizione;
		return this;
	}

	public AccusedOf setReato(String reato) {
		this.reato = reato;
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
		this.entityType = "ImputatoDi";
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
