package pl.sidor.movierentaldemo.entity.model;

import lombok.*;
import pl.sidor.movierentaldemo.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Movie extends BaseEntity<Long> {

    private static final long serialVersionUID = 2820627879720435255L;

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
