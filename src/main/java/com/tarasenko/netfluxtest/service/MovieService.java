package com.tarasenko.netfluxtest.service;

import com.tarasenko.netfluxtest.domain.Movie;
import com.tarasenko.netfluxtest.domain.MovieEvent;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService
{
  Flux<MovieEvent> events(String movieId);

  Mono<Movie> getMovieById(String id);

  Flux<Movie> getAllMovies();
}
