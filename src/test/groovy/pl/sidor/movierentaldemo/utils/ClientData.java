package pl.sidor.movierentaldemo.utils;

import pl.sidor.movierentaldemo.entity.embedded.Address;
import pl.sidor.movierentaldemo.entity.model.Client;

public class ClientData {

    public static Client getClient(){
        return  Client.builder()
                .name("Karol")
                .lastName("Sidor")
                .address(new Address())
                .phoneNumber(500500500)
                .build();
    }
}
