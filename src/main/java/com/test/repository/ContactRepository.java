package com.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

	List<Contact> findByNameNotLike(String name);

	List<Contact> findAll();

}
