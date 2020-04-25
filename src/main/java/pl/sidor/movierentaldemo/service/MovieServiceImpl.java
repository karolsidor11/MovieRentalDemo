package pl.sidor.movierentaldemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sidor.movierentaldemo.converter.MovieConverter;
import pl.sidor.movierentaldemo.model.Movie;
import pl.sidor.movierentaldemo.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Movie findMovieById(Long id) {
        return movieRepository.findById(id).orElse(new Movie());
    }

    @Override
    public List<Movie> findAllMovies() {
        List<Movie> movieList = new ArrayList<>();
        Iterable<Movie> movieIterable = movieRepository.findAll();
        movieIterable.forEach(movieList::add);

        return movieList;
    }

    @Override
    public Movie findByTitle(String title) {
        return movieRepository.findAllByTitle(title).orElse(new Movie());
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Optional<Movie> movieById = movieRepository.findById(movie.getId());
        return movieById.map(value -> MovieConverter.convertMovie(value, movie)).orElse(null);
    }

    @Override
    public boolean deleteMovieById(Long id) {
        if (movieRepository.findById(id).isPresent()) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
