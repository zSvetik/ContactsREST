package com.test.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Contact;
import com.test.service.ContactService;

@RestController
@RequestMapping("/hello")
public class ContactController {

	@Autowired
	ContactService contactService;
	
	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public synchronized ResponseEntity<List<Contact>> findAll(
			@RequestParam(value = "nameFilter", defaultValue = "^$") final String name) {
		List<Contact> listContacts = contactService.findAll().parallelStream().filter(contact -> !contact.getName().matches(name)).collect(Collectors.toList());
		if (listContacts.isEmpty()) {
			return new ResponseEntity<List<Contact>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Contact>>(listContacts, HttpStatus.OK);
	}
	
	/*
	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public synchronized ResponseEntity<List<Contact>> getContactsByPattern(
			@RequestParam(value = "nameFilter", defaultValue = "%") String name) {
		name = Utils.javaPatternToSQL(name);
		List<Contact> listContacts = contactService.findByNameNotLike(name);
		if (listContacts.isEmpty()) {
			return new ResponseEntity<List<Contact>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Contact>>(listContacts, HttpStatus.OK);
	}
	*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public synchronized ResponseEntity<List<Contact>> notFound() {
		return new ResponseEntity<List<Contact>>(HttpStatus.NOT_FOUND);
	}

}
