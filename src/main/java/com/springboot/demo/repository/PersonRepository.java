package com.springboot.demo.repository;

import com.springboot.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

  boolean existsById(Long id);

  Person findById(Long id);
}
