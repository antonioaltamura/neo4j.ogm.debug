package com.neo4j.ogm.test.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.neo4j.ogm.typeconversion.CompositeAttributeConverter;

public class ObjPropConverter implements CompositeAttributeConverter<List<ObjProp>> {
	@Override
	public Map toGraphProperties(List<ObjProp> agg) {
		
		HashMap<String,Map<String,String>> props = new HashMap<>();
		HashMap<String,String> m = new HashMap<String,String>();
		m.put("k1", "v1");
		m.put("k2", "v2");
		
		HashMap<String,String> m2 = new HashMap<String,String>();
		m2.put("k3", "v3");
		m2.put("k4", "v4");
		props.put("A",m);
		props.put("B",m2);
		return props;
	}
	@Override
	public List<ObjProp> toEntityAttribute(Map aggMap) {
		ArrayList<ObjProp> ret = new ArrayList<ObjProp>();
		 Iterator it = aggMap.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry map = (Map.Entry)it.next();
		        Iterator it_entry = ((Map) map).entrySet().iterator();
		        HashMap<String,String> el = new HashMap<String,String>();  
			    while (it_entry.hasNext()) {
			    	Map.Entry entry = (Map.Entry)it_entry.next();
			    	ObjProp a = new ObjProp((String)entry.getKey(), (String)entry.getValue());
			        //System.out.println(" entry: "+ entry.getKey() + " = " + entry.getValue());
			        ret.add(a);
			    }
		    }
		return ret;
	}
}