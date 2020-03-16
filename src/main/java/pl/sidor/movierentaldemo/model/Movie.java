package pl.sidor.movierentaldemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Author")
    private String author;

    @Column(name = "Year")
    private Date year;

    @Column(name = "Type")
    private String type;

    @Column(name = "Evaluation")
    private double evaluation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.evaluation, evaluation) == 0 && Objects.equals(title, movie.title) && Objects.equals(author, movie.author) && Objects.equals(year, movie.year) && Objects.equals(type, movie.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year, type, evaluation);
    }
}
