package com.hiberbabl.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "album")
public class Album {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(name = "TITLE")
  private String title;

  @Column(name = "RELEASE_DATE")
  private Date releaseDate;

  @NotNull
  @Column(name = "VERSION")
  private int version;

  @ManyToOne
  @JoinColumn(name = "SINGER_ID")
  private Singer singer;
}
