package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Contact;
import com.test.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;

	public List<Contact> findByNameNotLike(String name) {
		return contactRepository.findByNameNotLike(name);
	}

	@Override
	public List<Contact> findAll() {
		return contactRepository.findAll();
	}

}
