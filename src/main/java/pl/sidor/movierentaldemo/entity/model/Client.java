package pl.sidor.movierentaldemo.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sidor.movierentaldemo.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Client extends BaseEntity {

    @Column(name = "Name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "phoneNumber")
    private int phoneNumber;

    @Embedded
    private Addres adres;

    @OneToMany
    private List<Movie> movieList;
}
