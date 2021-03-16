package com.hiberbabl.service.impl;

import com.hiberbabl.dao.SingerDao;
import com.hiberbabl.entity.Singer;
import com.hiberbabl.service.SingerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SingerServiceImpl implements SingerService {

  private final SingerDao singerDao;

  @Override
  @Transactional
  public void save(Singer singer) {
    singerDao.save(singer);
  }

  @Override
  @Transactional
  public Singer findById(Long id) {
    return singerDao.findById(id);
  }

  @Override
  @Transactional
  public void update(Singer singer) {
    singerDao.update(singer);
  }

}
