package com.d2ycode.helloworld.services;

import java.util.List;

import com.d2ycode.helloworld.models.Hero;

public interface HeroService {

  List<Hero> heroList();

  Hero addNewHero(Hero requestHero);

  Boolean editHero(Hero requestHero, Integer id);

  Boolean deleteHero(Integer id);

  Boolean changeStatus(Integer id, Boolean isNewHero);

}
