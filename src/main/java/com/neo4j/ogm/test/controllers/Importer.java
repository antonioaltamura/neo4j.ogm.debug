package com.neo4j.ogm.test.controllers;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.neo4j.ogm.test.models.*;
import com.neo4j.ogm.test.repository.*;


public class Importer {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private AccusedOfRepository accusedOfRepository;
	@Autowired
	private ReatoRepository reatoRepository;


	@Autowired
	public Importer(PersonRepository personRepository, AccusedOfRepository accusedOfRepository, ReatoRepository reatoRepository ) {
		this.personRepository = personRepository;
		this.accusedOfRepository = accusedOfRepository;
		this.reatoRepository = reatoRepository ;
	}

	public String run() {

		personRepository.clear();
		accusedOfRepository.clear();
		reatoRepository.clear();

		Person a = new Person().setName("John").setNodeid("1");
		Person b = new Person().setName("Al").setNodeid("2");
		Person c = new Person().setName("Jack").setNodeid("3");
		personRepository.save(a);
		personRepository.save(b);
		personRepository.save(c);

		Reato d = new Reato().setName("E1").setNodeid("E1");
		Reato e = new Reato().setName("E2").setNodeid("E2");
		Reato f = new Reato().setName("E3").setNodeid("E3");
		reatoRepository.save(d);
		reatoRepository.save(e);
		reatoRepository.save(f);


		AccusedOf r = new AccusedOf();
		r
		.setSource(a)
		.setTarget(reatoRepository.getReatoByNodeid("E1"));
		
		r.setAggravante(new ObjProp("AGGR1","description"));
		accusedOfRepository.save(r);

		return "allright then..";
	}
}
