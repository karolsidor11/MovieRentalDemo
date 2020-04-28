package pl.sidor.movierentaldemo.utils;

import pl.sidor.movierentaldemo.entity.model.Addres;
import pl.sidor.movierentaldemo.entity.model.Client;

public class ClientData {

    public static Client getClient(){
        return  Client.builder()
                .name("Karol")
                .lastName("Sidor")
                .adres(new Addres())
                .phoneNumber(500500500)
                .build();
    }
}
