package com.neo4j.ogm.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neo4j.ogm.test.models.*;
import com.neo4j.ogm.test.repository.*;


@Controller
@RequestMapping(value = "/import")
public class ImportController {
	/**
	 * Populates Neo4j DB 
	 *
	 */
	@Autowired
	private IndividuoRepository individuoRepository;
	@Autowired
	private ReatoRepository reatoRepository;
	@Autowired
	private ImputatoDiRepository imputatoDiRepository;

	//@Qualifier("SessionService")
	//private SessionInterface service;

	/*@Autowired
	public ImportController(SessionInterface service) {
		this.service = service;
	}
	 */

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody String all() {
		return new Importer(individuoRepository, imputatoDiRepository, reatoRepository).run();
	}
}