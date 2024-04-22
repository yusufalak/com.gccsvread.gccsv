package com.gccsvread.csvread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gccsvread.csvread.ParseCsvService;
import com.gccsvread.csvread.ParseRequest;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ParseController {

	@Autowired
	private ParseCsvService parseCsvService;

	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/parse-csv")
	public String setFlightActiveStatus(@RequestBody ParseRequest req) throws Exception {
		parseCsvService.run(req);
		return "OK";
	}

}
