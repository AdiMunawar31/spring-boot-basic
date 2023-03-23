package com.d2ycode.helloworld.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.d2ycode.helloworld.services.HeroService;

@RestController
@RequestMapping("/api/v1/hero")
public class HeroMLBBController {

  @Autowired
  HeroService heroService;

  @GetMapping(path = "/list-hero")
  public List<Hero> heroList() {
    return heroService.heroList();
  }

  @PostMapping(path = "/add-hero")
  public Hero addNewHero(@RequestBody Hero requestHero) {
    return heroService.addNewHero(requestHero);
  }

  @PutMapping(path = "/edit-hero/{id}")
  public Boolean editHero(@RequestBody Hero requestHero, @PathVariable Integer id) {
    return heroService.editHero(requestHero, id);
  }

  @DeleteMapping(path = "/delete-hero/{id}")
  public Boolean deleteHero(@PathVariable Integer id) {
    return heroService.deleteHero(id);
  }

  @PatchMapping(path = "/change-status/{id}")
  public Boolean changeStatus(@PathVariable Integer id, @RequestParam Boolean isNewHero) {
    return heroService.changeStatus(id, isNewHero);
  }
}
