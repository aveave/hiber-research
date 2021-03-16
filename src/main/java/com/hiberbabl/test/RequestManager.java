package com.hiberbabl.test;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class RequestManager{


  private RequestHandler requestHandler;

  public void handleRequest(){
    requestHandler = getRequestHandler();
    requestHandler.handleRequest();
  }

  @Lookup
  public RequestHandler getRequestHandler() {
    return null;
  }
}