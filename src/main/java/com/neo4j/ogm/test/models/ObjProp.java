package com.neo4j.ogm.test.models;

public class ObjProp {
	private String name;
	private String descrizione;
	public ObjProp(String name, String descrizione){
		this.name = name;
		this.descrizione = descrizione;
	}
	public String getName() {
		return name;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
