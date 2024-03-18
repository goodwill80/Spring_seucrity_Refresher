package com.security.Lesson.on.spring.security.repository;

import com.security.Lesson.on.spring.security.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, String> {
}
