package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.MovieRepository;

@RestController
public class MovieController {
  @GetMapping("/")
  public String index(){
    return "forklaring på siden";
  }
  @GetMapping("/findall")
  public String findAll(){

    MovieRepository  movieRepository = new MovieRepository();
    return movieRepository.findAll();
  }
}
