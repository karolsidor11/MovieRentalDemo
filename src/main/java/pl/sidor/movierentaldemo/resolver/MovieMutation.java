package pl.sidor.movierentaldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sidor.movierentaldemo.model.Movie;
import pl.sidor.movierentaldemo.service.MovieService;

@Component
@RequiredArgsConstructor
public class MovieMutation implements GraphQLMutationResolver {

    private final MovieService movieService;

    public Movie createMovie(Movie movie) {
        return movieService.createMovie(movie);
    }

    public Movie updateMovie(Movie movie) {
        return movieService.updateMovie(movie);
    }

    public boolean deleteMovieById(Long id) {
        return movieService.deleteMovieById(id);
    }
}
