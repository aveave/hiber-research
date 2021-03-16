package com.hiberbabl.dao;

import com.hiberbabl.entity.Album;

import java.util.List;

public interface AlbumDao {

  List<Album> findAll();

  Album findById(Long id);

  void save(Album album);

  void delete(Album album);

  void deleteById(Long id);
}
