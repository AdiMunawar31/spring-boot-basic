package com.d2ycode.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  // Query Parameters
  @GetMapping(path = "/hello")
  public String hello(@RequestParam("name") String name) {
    return "Hello " + name + ", Selamat datang";
  }

  // Path Variable
  @GetMapping(path = "/welcome/{hero}")
  public String welcome(@PathVariable("hero") String hero) {
    return "Welcome to Mobile Legend " + hero;
  }
}