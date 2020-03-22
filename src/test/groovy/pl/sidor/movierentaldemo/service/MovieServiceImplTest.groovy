package pl.sidor.movierentaldemo.service

import pl.sidor.movierentaldemo.model.Movie
import pl.sidor.movierentaldemo.repository.MovieRepository
import spock.lang.Specification
import spock.lang.Unroll

class MovieServiceImplTest extends Specification {

    MovieRepository movieRepository = Mock()

    MovieServiceImpl movieService = [movieRepository]

    def "should find Movie by ID"() {
        given:
        Long id = 1L

        when:
        movieRepository.findById(id) >> Optional.of(getMovie())
        def result = movieService.findMovieById(id)

        then:
        result != null
        result.id == 1L
        result.author == "Jan Nowak"
        result.evaluation == 5.0
    }

    def "should return new Movie if dont find in database"() {
        given:
        Long id = 999L

        when:
        movieRepository.findById(id) >> Optional.empty()
        def result = movieService.findMovieById(id)

        then:
        result != null
        result.id == null
        result.author == null
    }

    @Unroll
    def "should find all Movies"() {
        when:
        movieRepository.findAll() >> list
        def result = movieService.findAllMovies()

        then:
        result.size() == expectedResult

        where:
        list                     | expectedResult
        []                       | 0
        [getMovie()]             | 1
        [getMovie(), getMovie()] | 2
    }

    @Unroll
    def "should find Movie by title"() {
        when:
        movieRepository.findAllByTitle(title as String) >> movies
        def result = movieService.findByTitle(title)

        then:
        result.title == expectedResult

        where:
        title     | movies                  | expectedResult
        "Titanic" | Optional.of(getMovie()) | "Titanic"
        "Pirates" | Optional.empty()        | null

    }

    def "should create Movie"() {
        given:
        Movie movie = getMovie()

        when:
        movieRepository.save(movie) >> movie
        def result = movieService.createMovie(movie)

        then:
        result != null
        result.getId() == 1L
        result.getTitle() == "Titanic"
        result.getEvaluation() == 5.0
    }

    def "should update Movie"() {
        given:
        Movie oldMovie = getMovie()
        Movie updateMovie = getNewsetMovie()

        when:
        movieRepository.findById(oldMovie.id) >> Optional.of(oldMovie)
        def result = movieService.updateMovie(updateMovie)

        then:
        result != null
        result.getEvaluation() == 4.8
        result.getAuthor() == "Jan Kowalski"

    }

    @Unroll
    def "should delete Movie by ID"() {
        when:
        movieRepository.findById(id) >> movies
        def result = movieService.deleteMovieById(id)

        then:
        result == expectedResult

        where:
        id | movies                  | expectedResult
        1L | Optional.of(getMovie()) | true
        1L | Optional.empty()        | false

    }

    private static Movie getMovie() {
        return Movie.builder()
                .id(1)
                .title("Titanic")
                .author("Jan Nowak")
                .evaluation(5.0)
                .type("Dramat")
                .build()
    }

    private static Movie getNewsetMovie() {
        return Movie.builder()
                .id(1)
                .title("Titanic")
                .author("Jan Kowalski")
                .evaluation(4.8)
                .type("Dramat")
                .build()
    }

}
