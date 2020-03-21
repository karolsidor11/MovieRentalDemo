package pl.sidor.movierentaldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sidor.movierentaldemo.model.Movie;
import pl.sidor.movierentaldemo.service.MovieService;

@Component
@RequiredArgsConstructor
public class MovieQuery implements GraphQLQueryResolver {

    private final MovieService movieService;

    public Movie findMovieById(Long id) {
        return movieService.findMovieById(id);
    }
}
