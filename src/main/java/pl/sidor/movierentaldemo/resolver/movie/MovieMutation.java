package pl.sidor.movierentaldemo.resolver.movie;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sidor.movierentaldemo.entity.model.Movie;
import pl.sidor.movierentaldemo.service.movieservice.MovieService;

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
