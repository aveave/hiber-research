package com.hiberbabl.dao;

import com.hiberbabl.entity.Singer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SingerDaoImpl implements SingerDao {

  private SessionFactory sessionFactory;

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public List<Singer> findAll() {
    return sessionFactory.getCurrentSession().createQuery("SELECT a FROM Singer a", Singer.class).getResultList();
  }

  @Override
  public List<Singer> findAllWithAlbums() {
    return null;
  }

  @Override
  public Singer findById(Long id) {
    return sessionFactory.getCurrentSession().get(Singer.class, id);
  }

  @Override
  public void delete(Singer singer) {
    sessionFactory.getCurrentSession().delete(singer);
  }

  @Override
  public void save(Singer singer) {
    sessionFactory.getCurrentSession().persist(singer);
  }

  @Override
  public void update(Singer singer) {
    sessionFactory.getCurrentSession().update(singer);
  }
}
