package pl.sidor.movierentaldemo.service;

import pl.sidor.movierentaldemo.model.Movie;

import java.util.List;

public interface MovieService {

    Movie findMovieById(Long id);

    List<Movie> findAllMovies();

    Movie findByTitle(String title);

    Movie createMovie(Movie movie);

    Movie updateMovie(Movie movie);

    boolean deleteMovieById(Long id);
}
