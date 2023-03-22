package com.d2ycode.helloworld.models;

public class Hero {

  // unique identifier
  private int id;
  private String name;
  private int demage;

  public Hero(int id, String name, int demage) {
    this.id = id;
    this.name = name;
    this.demage = demage;
  }

  public Hero() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDemage() {
    return demage;
  }

  public void setDemage(int demage) {
    this.demage = demage;
  }

}
