package pl.sidor.movierentaldemo.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Builder(toBuilder = true)
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Addres {

    @Column(name = "Country")
    private String country;

    @Column(name = "City")
    private String city;

    @Column(name = "Street")
    private String street;

    @Column(name = "StreetNumber")
    private int streetNumber;

    @Column(name = "HouseNumber")
    private int houseNumber;
}
