package com.hiberbabl.service;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class SuperStateBean {

  private int temp = 10;

  private StateBean stateBean;

  public int getTemp() {
    return temp;
  }

  public void setTemp(int temp) {
    this.temp = temp;
  }

  @Lookup
  public StateBean getStateBean() {
    return null;
  }

  public void setStateBean(StateBean stateBean) {
    this.stateBean = stateBean;
  }
}
