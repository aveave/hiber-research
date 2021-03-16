package com.hiberbabl.dao;

import com.hiberbabl.entity.Instrument;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InstrumentDaoImpl implements InstrumentDao{

  @Autowired
  SessionFactory sessionFactory;

  @Override
  @Transactional
  public Long save(Instrument instrument) {
    return sessionFactory.getCurrentSession().save(instrument);
  }

  @Override
  @Transactional
  public Instrument findById(String id) {
    return sessionFactory.getCurrentSession().get(Instrument.class, id);
  }

  @Override
  @Transactional
  public void update(Instrument instrument) {
    sessionFactory.getCurrentSession().update(instrument);
  }

  @Transactional
  public void saveWrap(Instrument instrument) {
    save(instrument);
  }
}
