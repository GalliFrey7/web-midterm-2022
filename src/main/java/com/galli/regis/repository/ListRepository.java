package com.galli.regis.repository;

import com.galli.regis.models.Email;
import org.springframework.data.repository.CrudRepository;

public interface ListRepository extends CrudRepository<Email, Long> {
}
