package com.neo4j.ogm.test.models;

import java.util.List;
import java.util.Map;

public interface Entity<T> {
	T setId(Long id);
	Long getId();
	T setName(String s);
	String getName();
	String getEntityType();
}