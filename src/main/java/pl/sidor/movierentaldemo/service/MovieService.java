package pl.sidor.movierentaldemo.service;

import pl.sidor.movierentaldemo.model.Movie;

public interface MovieService {

    Movie findMovieById(Long id);
}
