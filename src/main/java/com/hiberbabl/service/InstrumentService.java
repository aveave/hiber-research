package com.hiberbabl.service;

import com.hiberbabl.entity.Instrument;

public interface InstrumentService {

  void save(Instrument instrument);

  Instrument findById(String id);

  void update(Instrument instrument);

  void saveWrap(Instrument instrument);
}
