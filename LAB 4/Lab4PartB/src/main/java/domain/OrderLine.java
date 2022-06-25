package domain;


import javax.persistence.*;

@Entity
@Table(name = "orderline")
public class OrderLine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int quantity;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Product product;

	public OrderLine() {
	}

	public OrderLine(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderLine{" +
				"id=" + id +
				", quantity=" + quantity +
				", product=" + product +
				'}';
	}
}
