package pl.sidor.movierentaldemo.converter;

import pl.sidor.movierentaldemo.entity.model.Movie;

public class MovieConverter {

    public static Movie convertMovie(Movie oldMovie, Movie newMovie) {
        return oldMovie.toBuilder()
                .title(newMovie.getTitle())
                .distributor(newMovie.getDistributor())
                .type(newMovie.getType())
                .evaluation(newMovie.getEvaluation())
                .year(newMovie.getYear())
                .build();
    }
}
