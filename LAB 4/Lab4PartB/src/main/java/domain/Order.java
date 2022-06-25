package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Entity
@Table(name = "orderTable")
public class Order {
	@Id
	@GeneratedValue
	private Long id;
	private String ordernr;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String status;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Collection<OrderLine> orderlines = new ArrayList<OrderLine>();

	public Order() {
	}

	public Order(String ordernr, Date  date, String status) {
		this.ordernr = ordernr;
		this.date = date;
		this.status = status;
	}



	public String getOrdernr() {
		return ordernr;
	}

	public void setOrdernr(String ordernr) {
		this.ordernr = ordernr;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date  date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<OrderLine> getOrderlines() {
		return Collections.unmodifiableCollection(orderlines);
	}

	public boolean addOrderLine(OrderLine ol) {
		return orderlines.add(ol);
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", ordernr='" + ordernr + '\'' +
				", date=" + date +
				", status='" + status + '\'' +

				'}';
	}
}
