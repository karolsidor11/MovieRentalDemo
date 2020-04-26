package pl.sidor.movierentaldemo.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sidor.movierentaldemo.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends BaseEntity {

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
