package pl.sidor.movierentaldemo.resolver

import pl.sidor.movierentaldemo.entity.model.Movie
import pl.sidor.movierentaldemo.resolver.movie.MovieQuery
import pl.sidor.movierentaldemo.service.movieservice.MovieServiceImpl
import pl.sidor.movierentaldemo.utils.MoveData
import spock.lang.Shared
import spock.lang.Specification

class MovieQueryTest extends Specification {

    MovieServiceImpl movieService = Mock(MovieServiceImpl.class)
    MovieQuery sut = [movieService]

    @Shared
    Long id = 1L
    String title = "Titanic"

    def "should find Movie by ID"() {
        when:
        movieService.findMovieById(id) >> MoveData.getMovie(id)
        def result = sut.findMovieById(id)

        then:
        noExceptionThrown()
        result.getTitle() == "Titanic"
    }

    def "should return empty Movie"() {
        when:
        movieService.findMovieById(id) >> new Movie()
        def result = sut.findMovieById(id)

        then:
        noExceptionThrown()
        result != null
    }

    def "should find Movie by title"() {
        when:
        movieService.findByTitle(title) >> MoveData.getMovie(id)
        def result = sut.findByTitle(title)

        then:
        noExceptionThrown()
        result != null
        result.title == title
    }

    def "should return empty Movie by title"() {
        when:
        movieService.findByTitle(title) >> new Movie()
        def result = sut.findByTitle(title)

        then:
        noExceptionThrown()
        result != null
    }

    def "should  find all Movies"() {
        when:
        movieService.findAllMovies() >> [MoveData.getMovie(id)]
        def result = sut.findAllMovies()

        then:
        noExceptionThrown()
        result!=null
        result.size()==1
    }
}
