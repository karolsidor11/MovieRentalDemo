package pl.sidor.movierentaldemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Distributor")
    private String distributor;

    @Column(name = "Year")
    private Date year;

    @Column(name = "Type")
    private String type;

    @Column(name = "Evaluation")
    private double evaluation;
}
