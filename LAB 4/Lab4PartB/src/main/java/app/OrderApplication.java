package app;

import domain.Customer;
import domain.Order;
import domain.OrderLine;
import domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.OrderRepository;

import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class OrderApplication implements CommandLineRunner{
	@Autowired
	private OrderRepository orderRepository;


	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product = new Product();
		product.setName("Hibernate 3");
		product.setDescription("Good book on Hibernate");
		product.setPrice(35.50);
		OrderLine ol1 = new OrderLine(2, product);
		Order order1 = new Order("4343",new Date(12/12/202),"Shipping");
		order1.addOrderLine(ol1);
		Customer customer1 = new Customer("Elice","Kimaro","1000N st.","Fairfield","52557");
		customer1.addOrder(order1);
		order1.setCustomer(customer1);
		orderRepository.save(order1);

		orderRepository.findAll().forEach(System.out::println);

		printOrder(order1);

	}

	public static void printOrder(Order order) {
		System.out.println("Order with orderNumber: " + order.getOrdernr());
		System.out.println("Order date: " + order.getDate());
		System.out.println("Order status: " + order.getStatus());
		Customer cust = order.getCustomer();
		System.out.println("Customer: " + cust.getFirstname() + " "
				+ cust.getLastname());
		for (OrderLine orderline : order.getOrderlines()) {
			System.out.println("Order line: quantity= "
					+ orderline.getQuantity());
			Product product = orderline.getProduct();
			System.out.println("Product: " + product.getName() + " "
					+ product.getDescription() + " " + product.getPrice());
		}

	}
}
