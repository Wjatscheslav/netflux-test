package com.tarasenko.netfluxtest.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.tarasenko.netfluxtest.domain.Movie;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String>
{
}
