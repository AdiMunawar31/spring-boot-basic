package com.d2ycode.helloworld.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @PutMapping(path = "/edit-hero/{id}")
  public Boolean editHero(@RequestBody Hero requestHero, @PathVariable Integer id) {
    final Optional<Hero> result = heroes.stream().filter(hero -> hero.getId() == id).findFirst();

    if (result.isPresent()) {
      result.get().setName(requestHero.getName());
      result.get().setDemage(requestHero.getDemage());

      return true;
    } else {
      return false;
    }
  }

  @DeleteMapping(path = "/delete-hero/{id}")
  public Boolean deleteHero(@PathVariable Integer id) {
    final Optional<Hero> result = heroes.stream().filter(hero -> hero.getId() == id).findFirst();

    if (result.isPresent()) {
      heroes.remove(result.get());

      return true;
    } else {
      return false;
    }
  }

  @PatchMapping(path = "/change-status/{id}")
  public Boolean changeStatus(@PathVariable Integer id, @RequestParam Boolean isNewHero) {
    final Optional<Hero> result = heroes.stream().filter(hero -> hero.getId() == id).findFirst();

    if (result.isPresent()) {
      result.get().setIsNewHero(isNewHero);

      return true;
    } else {
      return false;
    }
  }
}
