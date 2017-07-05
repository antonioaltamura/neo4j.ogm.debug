package com.neo4j.ogm.test.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.neo4j.ogm.typeconversion.CompositeAttributeConverter;

public class ObjPropConverter implements CompositeAttributeConverter<List<ObjProp>> {

	@Override
	public Map toGraphProperties(List<ObjProp> agg) {
		Map<String,String> props = new HashMap<>();
/*		if(agg!=null){
			props.put("name", agg.getName());
			props.put("descrizione", agg.getDescrizione());
		}*/
		return props;
	}

	@Override
	public List<ObjProp> toEntityAttribute(Map aggMap) {
		/*String name = (String) aggMap.get("name");
		String descrizione = (String) aggMap.get("descrizione");
		if (name != null && descrizione != null) {
			return new ObjProp(name, descrizione);
		}*/
		return new ArrayList<ObjProp>();
	}

}