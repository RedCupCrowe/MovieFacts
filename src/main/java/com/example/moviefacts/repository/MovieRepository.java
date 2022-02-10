package com.example.moviefacts.repository;

import com.example.moviefacts.model.Movie;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MovieRepository {
  //læse movies
  ArrayList<Movie> movieArrayList = new ArrayList<>();
  Random rand = new Random();

  public String findAll() {
    //findAll
    try {
      File file = new ClassPathResource("imdb-data.csv").getFile();
      Scanner scan = new Scanner(file);
      boolean overskrift = true;
      while (scan.hasNextLine()){
        //her skal hver linje i imdb.csv adskilles fra hinanden og oprette movie objekter for hver linje
        //men vi skriver bare ud
        if (overskrift) {
          String headline = scan.nextLine();
          overskrift = false;
        }else {
          String line = scan.nextLine();
          String[] wordsOnLine = line.split(";");
          boolean hasAwards = false;
          if (wordsOnLine[5].equalsIgnoreCase("yes")){
            hasAwards = true;
          }

          //Year;Length;Title;Subject;Popularity;Awards
          movieArrayList.add(new Movie(Integer.parseInt(wordsOnLine[0]),
              Integer.parseInt(wordsOnLine[1]),
              wordsOnLine[2],
              wordsOnLine[3],
              Integer.parseInt(wordsOnLine[4]),
              hasAwards));
        }

      }
    } catch (IOException e ){
      System.out.println("error reading file" + e);

    }
    String movieList = "";
    for (int i = 0; i < movieArrayList.size(); i++){
      movieList += movieArrayList.get(i) + "<br>";
    }
    return movieList;
  }

  public String getFirst(){

    return movieArrayList.get(0).getTitle();
  }
  public String getRandom(){

    return movieArrayList.get(rand.nextInt(movieArrayList.size())).getTitle();
  }
  public String getTenSortByPopularity(){
    ArrayList<Movie> tenMoviesList = new ArrayList<>();

    for (int i = 0; i < 10; i++) {

      tenMoviesList.add(movieArrayList.get(rand.nextInt(movieArrayList.size())));
    }
    String tenMovies = "";
    Collections.sort(tenMoviesList);
    for (int i = 0; i < tenMoviesList.size(); i++){
      tenMovies += tenMoviesList.get(i);
    }
    return tenMovies;
  }
}

