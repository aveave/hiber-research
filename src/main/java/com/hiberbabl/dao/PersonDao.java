package com.hiberbabl.dao;

import com.hiberbabl.entity.Person;

import java.util.List;

public interface PersonDao {

  List<Person> findAll();

  Person findById(Long id);

  void delete(Person person);

  void save(Person person);

  void update(Person person);
}
