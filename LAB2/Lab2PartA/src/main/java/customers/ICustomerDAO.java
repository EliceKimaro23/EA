package customers;

import org.springframework.stereotype.Service;

@Service
public interface ICustomerDAO {
	void save(Customer customer) ;
}
