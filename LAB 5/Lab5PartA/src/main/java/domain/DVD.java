package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("dvd")
public class DVD extends Product {

    private String genre;



    public DVD() {

    }

    public DVD(String name, String description, double price, String genre) {
        super(name, description, price);
        this.genre = genre;
    }
}
