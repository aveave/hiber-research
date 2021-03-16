package com.hiberbabl.service.impl;

import com.hiberbabl.dao.InstrumentDao;
import com.hiberbabl.entity.Instrument;
import com.hiberbabl.service.InstrumentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InstrumentServiceImpl  implements InstrumentService {

  private final InstrumentDao instrumentDao;

  public InstrumentServiceImpl(InstrumentDao instrumentDao) {
    this.instrumentDao = instrumentDao;
  }

  @Override
  public void save(Instrument instrument) {

  }

  @Override
  @Transactional
  public Instrument findById(String id) {
    Instrument instrument = instrumentDao.findById(id);
    System.out.println(instrument);
    return instrument;
  }

  @Override
  public void update(Instrument instrument) {

  }

  @Override
  public void saveWrap(Instrument instrument) {

  }
}
