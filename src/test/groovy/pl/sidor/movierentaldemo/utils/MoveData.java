package pl.sidor.movierentaldemo.utils;

import pl.sidor.movierentaldemo.entity.model.Movie;

import java.util.Date;

public class MoveData {

    public static Movie getMovie(Long id) {
        return Movie.builder()
                .title("Titanic")
                .year(new Date())
                .type("Drama")
                .distributor("Jonny Gose")
                .evaluation(4.8)
                .build();
    }
}
