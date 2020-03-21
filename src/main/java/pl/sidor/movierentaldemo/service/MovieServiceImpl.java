package pl.sidor.movierentaldemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sidor.movierentaldemo.model.Movie;
import pl.sidor.movierentaldemo.repository.MovieRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Movie findMovieById(Long id) {
        return movieRepository.findById(id).orElse(new Movie());
    }
}
