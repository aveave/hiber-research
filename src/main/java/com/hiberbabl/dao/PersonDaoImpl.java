package com.hiberbabl.dao;

import com.hiberbabl.entity.Person;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

  private final SessionFactory sessionFactory;

  public PersonDaoImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public List<Person> findAll() {
    return sessionFactory.getCurrentSession().createQuery("SELECT p from Person", Person.class).getResultList();
  }

  @Override
  public Person findById(Long id) {
    return sessionFactory.getCurrentSession().get(Person.class, id);
  }

  @Override
  public void delete(Person person) {
    sessionFactory.getCurrentSession().remove(person);
  }

  @Override
  @Transactional
  public void save(Person person) {
    sessionFactory.getCurrentSession().persist(person);
  }

  @Override
  public void update(Person person) {
    sessionFactory.getCurrentSession().update(person);
  }
}
