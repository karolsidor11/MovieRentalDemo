package pl.sidor.movierentaldemo.converter;

import org.jetbrains.annotations.NotNull;
import pl.sidor.movierentaldemo.entity.model.Movie;

public class MovieConverter {

    public static Movie convertMovie(@NotNull Movie oldMovie, @NotNull Movie newMovie) {
        return oldMovie.toBuilder()
                .title(newMovie.getTitle())
                .distributor(newMovie.getDistributor())
                .type(newMovie.getType())
                .evaluation(newMovie.getEvaluation())
                .year(newMovie.getYear())
                .build();
    }
}
