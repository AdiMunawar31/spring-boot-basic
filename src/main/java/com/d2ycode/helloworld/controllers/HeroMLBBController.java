package com.d2ycode.helloworld.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d2ycode.helloworld.models.Hero;

@RestController
@RequestMapping("/api/v1/hero")
public class HeroMLBBController {

  public List<Hero> heroes = new ArrayList<>();
  public Integer counter = 1;

  @GetMapping(path = "/list-hero")
  public List<Hero> heroList() {
    // heroes.add(new Hero(1, "Alucard", 99));
    // heroes.add(new Hero(2, "Fanny", 88));
    // heroes.add(new Hero(3, "Pharsa", 95));
    // heroes.add(new Hero(4, "Claude", 90));
    // heroes.add(new Hero(5, "Franco", 54));
    return heroes;
  }

  @PostMapping(path = "/add-hero")
  public Hero addNewHero(@RequestBody Hero requestHero) {
    requestHero.setId(counter);
    heroes.add(requestHero);
    counter++;

    return requestHero;
  }

}
