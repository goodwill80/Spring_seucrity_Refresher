package com.security.Lesson.on.spring.security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactions extends CrudRepository<AccountTransactions, Long> {
}