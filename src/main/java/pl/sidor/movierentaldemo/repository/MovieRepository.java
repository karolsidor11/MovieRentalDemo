package pl.sidor.movierentaldemo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sidor.movierentaldemo.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
