package com.tarasenko.netfluxtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tarasenko.netfluxtest.domain.Movie;
import com.tarasenko.netfluxtest.domain.MovieEvent;
import com.tarasenko.netfluxtest.service.MovieService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MovieController
{

  private final MovieService movieService;

  public MovieController(MovieService movieService)
  {
    this.movieService = movieService;
  }

  @GetMapping(value = "/{id}/events")
  public Flux<MovieEvent> streamMovieEvents(@PathVariable String id) {
    return movieService.events(id);
  }

  @GetMapping(value = "/{id}")
  public Mono<Movie> getMovieById(@PathVariable String id) {
    return movieService.getMovieById(id);
  }

  @GetMapping
  public Flux<Movie> getAllMovies() {
    return movieService.getAllMovies();
  }
}
