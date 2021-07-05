package pl.sidor.movierentaldemo.entity.model;

import lombok.*;
import pl.sidor.movierentaldemo.entity.base.BaseEntity;
import pl.sidor.movierentaldemo.entity.embedded.Address;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Client extends BaseEntity<Long> {

    private static final long serialVersionUID = -3378558174851808278L;

    @Column(name = "Name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "phoneNumber")
    private int phoneNumber;

    @Embedded
    private Address address;

    @OneToMany
    private List<Movie> movieList;
}
