package repository;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MovieRepository {
  //læse movies

  public String findAll() {


    //findAll
    try {
      File file = new ClassPathResource("imdb.csv").getFile();
      Scanner scan = new Scanner(file);
      while (scan.hasNext()){
        //her skal hver linje i imdb.csv adskilles fra hinanden og oprette movie objekter for hver linje
        //men vi skriver bare ud
        System.out.println(scan.next());

      }
    } catch (IOException e ){
      System.out.println("error reading file");

    }
    return "her skal filmene blive spyttet ud";
  }
}

