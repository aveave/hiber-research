package com.hiberbabl.dao;

import com.hiberbabl.entity.Instrument;
import org.springframework.transaction.annotation.Transactional;

public interface InstrumentDao {

  Long save(Instrument instrument);

  Instrument findById(String id);

  void update(Instrument instrument);

  void saveWrap(Instrument instrument);

}
