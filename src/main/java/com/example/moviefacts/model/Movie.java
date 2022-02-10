package com.example.moviefacts.model;


public class Movie implements Comparable<Movie> { //implements Compareable

  //Year;Length;Title;Subject;Popularity;Awards
  int year;
  int length;
  String title;
  String subject;
  int popularity;
  boolean awards;

  public Movie(int year, int length, String title, String subject, int popularity, boolean hasAwards) {
    this.year = year;
    this.length = length;
    this.title = title;
    this.subject = subject;
    this.popularity = popularity;
    this.awards = hasAwards;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public void setPopularity(int popularity) {
    this.popularity = popularity;
  }

  public void setAwards(boolean awards) {
    this.awards = awards;
  }


  public int getYear() {
    return year;
  }

  public int getLength() {
    return length;
  }

  public String getTitle() {
    return title;
  }

  public String getSubject() {
    return subject;
  }

  public int getPopularity() {
    return popularity;
  }

  public boolean isAwards() {
    return awards;
  }

  @Override
  public String toString() {
    return "Movie{" +
        "year=" + year +
        ", length=" + length +
        ", title='" + title + '\'' +
        ", subject='" + subject + '\'' +
        ", popularity=" + popularity +
        ", awards=" + awards +
        '}';
  }


  @Override
  public int compareTo(Movie o) {

    return this.popularity - o.popularity;
  }

  //getters, setters, constructor, toString, compareable/comparator
}
