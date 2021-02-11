package pl.pwojaczek.vouchershop.sales;

import pl.pwojaczek.vouchershop.sales.offering.Offer;

import javax.persistence.Entity;
import java.util.UUID;

public class Reservation {
    String id;

    public Reservation(){
        this.id = UUID.randomUUID().toString();
    }

    public static Reservation of(Offer offer, ClientData clientData)
    {
        return new Reservation();
    }

    public String getId() {
        return UUID.randomUUID().toString();
    }
}
