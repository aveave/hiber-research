package com.hiberbabl.dao;

import com.hiberbabl.entity.Singer;

import java.util.List;

public interface SingerDao {

  List<Singer> findAll();

  List<Singer> findAllWithAlbums();

  Singer findById(Long id);

  void delete(Singer singer);

  void save(Singer singer);

  void update(Singer singer);

}
