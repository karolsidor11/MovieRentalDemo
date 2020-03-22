package pl.sidor.movierentaldemo.converter

import pl.sidor.movierentaldemo.model.Movie
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
        result.id==1
        result.author=="Jan Kowalski"
        result.evaluation == 4.8
    }

    private static Movie getOldMovie() {
        return Movie.builder()
                .id(1)
                .title("Titanic")
                .author("Jan Nowak")
                .evaluation(5.0)
                .type("Dramat")
                .build()
    }

    private static Movie getNewMovie() {
        return Movie.builder()
                .title("Titanic")
                .author("Jan Kowalski")
                .evaluation(4.8)
                .type("Dramat-romatyczny")
                .build()
    }
}
