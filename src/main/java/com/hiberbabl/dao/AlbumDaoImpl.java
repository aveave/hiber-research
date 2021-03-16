package com.hiberbabl.dao;

import com.hiberbabl.entity.Album;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlbumDaoImpl implements AlbumDao {

  private final SessionFactory sessionFactory;

  public AlbumDaoImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  @Transactional
  public List<Album> findAll() {
    return sessionFactory.getCurrentSession().createQuery("SELECT a FROM album", Album.class).getResultList();
  }

  @Override
  public Album findById(Long id) {
    return null;
  }

  @Override
  @Transactional
  public void save(Album album) {
    sessionFactory.getCurrentSession().persist(album);
  }

  @Override
  public void delete(Album album) {

  }

  @Override
  public void deleteById(Long id) {

  }
}
