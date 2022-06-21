package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;

public class ReviewDTO_bkp implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String text;
  private Movie movie;

  public ReviewDTO_bkp() {
  }

  public ReviewDTO_bkp(final Long id, final String text, final Movie movie) {
    this.id = id;
    this.text = text;
    this.movie = movie;
  }

  public ReviewDTO_bkp(Review entity) {
    id = entity.getId();
    text = entity.getText();
    movie = entity.getMovie();
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(final String text) {
    this.text = text;
  }

  public Movie getMovie() {
    return movie;
  }

  public void setMovie(final Movie movie) {
    this.movie = movie;
  }
}
