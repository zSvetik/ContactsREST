package com.test.service;

import java.util.List;

import com.test.entity.Contact;

public interface ContactService {

	List<Contact> findByNameNotLike(String name);

	List<Contact> findAll();

}
