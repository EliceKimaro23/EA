package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{

        private  IProductDAO  productDAO;
        private IEmailSender emailSender;

        @Autowired
        public void setProductDAO (IProductDAO  productDAO){
         this.productDAO = productDAO;
        }
        @Autowired
        public void setEmailSender(IEmailSender emailSender){
            this.emailSender = emailSender;
        }

    @Override
    public void addPoduct(String name, String email, Double price) {
        Product product = new Product(name,price,email);
        productDAO.save(product);
        emailSender.sendEmail(email, "Product " + name + " was added");

    }
}


