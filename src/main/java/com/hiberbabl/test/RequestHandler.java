package com.hiberbabl.test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class RequestHandler {
  public RequestHandler(){
    System.out.println("In Request Handler Constructor");
  }
  public void handleRequest(){
    System.out.println("Handling request");
  }
}
