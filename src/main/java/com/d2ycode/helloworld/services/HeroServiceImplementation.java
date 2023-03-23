package com.d2ycode.helloworld.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.d2ycode.helloworld.models.Hero;

@Service
public class HeroServiceImplementation implements HeroService {

  public List<Hero> heroes = new ArrayList<>();
  public Integer counter = 1;

  @Override
  public List<Hero> heroList() {
    return heroes;
  }

  @Override
  public Hero addNewHero(Hero requestHero) {
    requestHero.setId(counter);
    heroes.add(requestHero);
    counter++;

    return requestHero;
  }

  @Override
  public Boolean changeStatus(Integer id, Boolean isNewHero) {
    final Optional<Hero> result = heroes.stream().filter(hero -> hero.getId() == id).findFirst();

    if (result.isPresent()) {
      result.get().setIsNewHero(isNewHero);

      return true;
    } else {
      return false;
    }
  }

  @Override
  public Boolean editHero(Hero requestHero, Integer id) {
    final Optional<Hero> result = heroes.stream().filter(hero -> hero.getId() == id).findFirst();

    if (result.isPresent()) {
      result.get().setName(requestHero.getName());
      result.get().setDemage(requestHero.getDemage());

      return true;
    } else {
      return false;
    }
  }

  @Override
  public Boolean deleteHero(Integer id) {
    final Optional<Hero> result = heroes.stream().filter(hero -> hero.getId() == id).findFirst();

    if (result.isPresent()) {
      heroes.remove(result.get());

      return true;
    } else {
      return false;
    }
  }

}
