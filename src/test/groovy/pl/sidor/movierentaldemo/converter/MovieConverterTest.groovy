package pl.sidor.movierentaldemo.converter

import pl.sidor.movierentaldemo.entity.model.Movie
import spock.lang.Specification

class MovieConverterTest extends Specification {

    def "should convert new Movie to old Movie"() {
        given:
        Movie oldMovie=getOldMovie()
        Movie newMovie=getNewMovie()

        when:
        def result = MovieConverter.convertMovie(oldMovie, newMovie)

        then:
        result!=null
        result.distributor=="Jan Kowalski"
        result.evaluation == 4.8
    }

    private static Movie getOldMovie() {
        return Movie.builder()
                .title("Titanic")
                .distributor("Jan Nowak")
                .evaluation(5.0)
                .type("Dramat")
                .build()
    }

    private static Movie getNewMovie() {
        return Movie.builder()
                .title("Titanic")
                .distributor("Jan Kowalski")
                .evaluation(4.8)
                .type("Dramat-romatyczny")
                .build()
    }
}
