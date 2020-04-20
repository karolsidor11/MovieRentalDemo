package pl.sidor.movierentaldemo.converter;

import pl.sidor.movierentaldemo.model.Movie;

public class MovieConverter {

    public static Movie convertMovie(Movie oldMovie, Movie newMovie) {
        return oldMovie.toBuilder()
                .title(newMovie.getTitle())
                .author(newMovie.getAuthor())
                .type(newMovie.getType())
                .evaluation(newMovie.getEvaluation())
                .year(newMovie.getYear())
                .build();
    }
}