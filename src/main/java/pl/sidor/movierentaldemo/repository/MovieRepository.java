package pl.sidor.movierentaldemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sidor.movierentaldemo.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
}
