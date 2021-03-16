package com.hiberbabl.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "instrument")
public class Instrument {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "INSTRUMENT_ID")
  private Long instrumentId;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(name = "singer_instrument",
          joinColumns = @JoinColumn(name = "INSTRUMENT_ID"),
          inverseJoinColumns = @JoinColumn(name = "SINGER_ID"))
  private Set<Singer> singers = new HashSet<>();

  @Override
  public String toString() {
    System.out.println("Set ----------");
    for (Singer singer: singers) {
      System.out.println("Singer{" +
              "id=" + singer.getId() +
              ", firstName='" + singer.getFirstName() + '\'' +
              ", lastName='" + singer.getLastName() + '\'' +
              ", version=" + singer.getVersion() +
              ", birthDate=" + singer.getBirthDate() +
              ", albums=" + singer.getAlbums() +
//              ", instruments=" + singer.getInstruments() +
              '}');
    }
    System.out.println("End ----------");
    return "Instrument{" +
            "instrumentId='" + instrumentId + '\'' +
            ", singers=" + singers +
            '}';
  }
}
