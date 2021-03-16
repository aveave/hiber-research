package com.hiberbabl.service;

import com.hiberbabl.entity.Singer;

public interface SingerService {

  void save(Singer singer);

  Singer findById(Long id);

  void update(Singer singer);

}
