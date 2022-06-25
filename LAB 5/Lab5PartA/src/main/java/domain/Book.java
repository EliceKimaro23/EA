package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("book")
public class Book extends Product{
    private String isbn;

    public Book(String name, String description, double price, String isbn) {
        super(name, description, price);
        this.isbn = isbn;
    }

    public Book() {

    }
}
