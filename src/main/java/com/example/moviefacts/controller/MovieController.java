package com.example.moviefacts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.moviefacts.repository.MovieRepository;

@RestController
public class MovieController {
  MovieRepository movieRepository = new MovieRepository();
  @GetMapping("/")
  public String index(){
    return "forklaring på siden";
  }

  @GetMapping("/findall")
  public String findAll(){

    return movieRepository.findAll();
  }
  @GetMapping("/getfirst")
  public String getFirst(){

    movieRepository.findAll();
    return movieRepository.getFirst();
  }
  @GetMapping("/getrandom")
  public  String getRandom(){

    return movieRepository.getRandom();
  }
  @GetMapping("/gettensortbypopularity")
  public String getTenSortByPopularity(){
    movieRepository.findAll();
    return movieRepository.getTenSortByPopularity();
  }
}
