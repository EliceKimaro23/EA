package domain;


import javax.persistence.*;

@Entity
@Table(name = "Patient_table")
@SecondaryTable(name = "Address_table")
public class Patient {
	@Id
	@GeneratedValue
	@Column(name = "patient_id")
     private Long id;
	private String name;
	@Column(table = "Address_table")
	private String street;
	@Column(table = "Address_table")
	private String zip;
	@Column(table = "Address_table")
	private String city;

	public Patient() {
	}

	public Patient(String name, String street, String zip, String city) {
		this.name = name;
		this.street = street;
		this.zip = zip;
		this.city = city;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
