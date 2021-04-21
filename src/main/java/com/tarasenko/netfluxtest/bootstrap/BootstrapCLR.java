package com.tarasenko.netfluxtest.bootstrap;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tarasenko.netfluxtest.domain.Movie;
import com.tarasenko.netfluxtest.repository.MovieRepository;

import reactor.core.publisher.Flux;

@Component
public class BootstrapCLR implements CommandLineRunner
{

  private final MovieRepository movieRepository;

  public BootstrapCLR(MovieRepository movieRepository)
  {
    this.movieRepository = movieRepository;
  }

  @Override
  public void run(String... args)
  {
    movieRepository.deleteAll().block();

    Flux.just("The Dark Knight", "Inception", "Moonlight", "The Social Network", "Avengers: Infinity War",
      "Get Out", "Pan's Labyrinth", "Lost In Translation")
        .map(title -> new Movie(UUID.randomUUID().toString(), title))
        .flatMap(movieRepository::save)
        .subscribe(null, null, () -> movieRepository.findAll().subscribe(System.out::println));
  }
}
