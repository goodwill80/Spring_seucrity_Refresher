package com.security.Lesson.on.spring.security.repository;

import com.security.Lesson.on.spring.security.model.Accounts;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CustomerRepository<Accounts, Long> {
    Accounts findByCustomerId(int customerId);
}
