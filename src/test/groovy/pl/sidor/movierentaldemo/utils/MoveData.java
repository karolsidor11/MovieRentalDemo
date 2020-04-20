package pl.sidor.movierentaldemo.utils;

import pl.sidor.movierentaldemo.model.Movie;

import java.util.Date;

public class MoveData {

    public static Movie getMovie(Long id) {
        return Movie.builder()
                .id(id)
                .title("Titanic")
                .year(new Date())
                .type("Drama")
                .author("Jonny Gose")
                .evaluation(4.8)
                .build();
    }
}
