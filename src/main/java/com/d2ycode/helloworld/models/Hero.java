package com.d2ycode.helloworld.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hero {

  // unique identifier
  private int id;
  private String name;
  private int demage;
  private Boolean isNewHero;
}
