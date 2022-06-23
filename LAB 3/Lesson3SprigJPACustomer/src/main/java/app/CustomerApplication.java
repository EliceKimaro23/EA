package app;


import java.util.Optional;

import domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import repositories.BookRepository;
import repositories.CustomerRepository;
import domain.Customer;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class CustomerApplication implements CommandLineRunner {

    @Autowired
    CustomerRepository customerrepository;

    @Autowired
    BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        customerrepository.save(new Customer("Jack", "Bauer", "jack@acme.com"));
        customerrepository.save(new Customer("Chloe", "O'Brian", "chloe@acme.com"));
        customerrepository.save(new Customer("Kim", "Bauer", "kim@acme.com"));
        customerrepository.save(new Customer("David", "Palmer", "dpalmer@gmail.com"));
        customerrepository.save(new Customer("Michelle", "Dessler", "mich@hotmail.com"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : customerrepository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer by ID
        Optional<Customer> custOpt = customerrepository.findById(1L);
        Customer customer = custOpt.get();
        System.out.println("Customer found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(customer);
        System.out.println();


//        BOOKS

        Book java = new Book("Programming in Java", "T20", "Henry", 500.00);
        Book ea = new Book("Programming in EA", "J20", "Peter", 900.00);
        Book sa = new Book("Programming in SA", "Z20", "Peter", 100.00);


        // SAVING THE BOOKS
        bookRepository.save(java);
        bookRepository.save(ea);
        bookRepository.save(sa);

//  RETRIEVING BOOKS FROM THE DATABASE
        System.out.println("Books found with find all");
        for (Book book : bookRepository.findAll()) {
            System.out.println(book);
        }

//   UPDATING A BOOK
        java.setAuthor("Noble");
        bookRepository.save(java);

        //  RETRIEVING BOOKS FROM THE DATABASE AFTER UPDATING
        System.out.println("Books found with find all after updating");
        for (Book book : bookRepository.findAll()) {
            System.out.println(book);
        }

//DELETING THE BOOK
        bookRepository.delete(ea);
        System.out.println("Books found with find all after deletion");
        for (Book book : bookRepository.findAll()) {
            System.out.println(book);
        }

    }
}
