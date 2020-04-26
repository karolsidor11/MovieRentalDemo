package pl.sidor.movierentaldemo.service.movieservice;

import pl.sidor.movierentaldemo.entity.model.Movie;

import java.util.List;

public interface MovieService {

    Movie findMovieById(Long id);

    List<Movie> findAllMovies();

    Movie findByTitle(String title);

    Movie createMovie(Movie movie);

    Movie updateMovie(Movie movie);

    boolean deleteMovieById(Long id);
}
