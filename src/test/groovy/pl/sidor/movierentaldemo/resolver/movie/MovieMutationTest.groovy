package pl.sidor.movierentaldemo.resolver.movie

import pl.sidor.movierentaldemo.entity.model.Movie
import pl.sidor.movierentaldemo.resolver.movie.MovieMutation
import pl.sidor.movierentaldemo.service.movieservice.MovieServiceImpl
import pl.sidor.movierentaldemo.utils.MoveData
import spock.lang.Shared
import spock.lang.Specification

class MovieMutationTest extends Specification {

    MovieServiceImpl movieService = Mock(MovieServiceImpl.class)
    MovieMutation sut = [movieService]

    @Shared
    Long id = 1L

    @Shared
    Movie movie = MoveData.getMovie(id)

    def "should create Movie"() {
        given:
        Movie movie = MoveData.getMovie(id)

        when:
        movieService.createMovie(movie) >> movie
        def result = sut.createMovie(movie)

        then:
        noExceptionThrown()
        result != null
        result.title == "Titanic"
    }

    def "should update Movie"() {
        given:
        Movie movie = MoveData.getMovie(id)
        Movie currentMovie = movie.toBuilder()
                .title("MadeMax")
                .distributor("Jonny Waker")
                .build();

        when:
        movieService.updateMovie(movie) >> currentMovie
        def result = sut.updateMovie(movie)

        then:
        noExceptionThrown()
        result != null
        result.title == currentMovie.title
    }

    def "should  return true if delete Movie by ID"() {
        when:
        movieService.deleteMovieById(id) >> true
        def result = sut.deleteMovieById(id)

        then:
        noExceptionThrown()
        result
    }

    def "should  return false if not  delete Movie by ID"() {
        when:
        movieService.deleteMovieById(id) >> false
        def result = sut.deleteMovieById(id)

        then:
        noExceptionThrown()
        !result
    }
}
