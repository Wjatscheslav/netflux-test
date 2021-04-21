package com.tarasenko.netfluxtest.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MovieEvent
{
  private String movieId;
  private Date date;
}
