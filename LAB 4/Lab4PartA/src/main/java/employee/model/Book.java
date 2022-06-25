package employee.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "isbn")
    private Long isbn;
    private String tittle;
    private String author;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinTable(name = "book_pub")
    private Publisher publisher;

    public Book() {
    }

    public Book( String tittle, String author) {
        this.tittle = tittle;
        this.author = author;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", tittle='" + tittle + '\'' +
                ", author='" + author + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
