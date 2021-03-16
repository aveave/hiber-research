package com.hiberbabl.service;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class StateBean {

  private int p = 10;

  public int getP() {
    return p;
  }

  public void setP(int p) {
    this.p = p;
  }
}
