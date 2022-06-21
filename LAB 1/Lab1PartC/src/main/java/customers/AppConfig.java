package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CustomerService customerService() {
        CustomerService customerService = new CustomerService();
        customerService.setCustomerDAO(customerDAO());
        customerService.setEmailSender(emailSender());
        return customerService;
    }

    @Bean
    public IEmailSender emailSender() {
        return new EmailSender(logger());
    }

    @Bean
    public ILogger logger() {
        return new Logger();
    }

    @Bean
    public ICustomerDAO customerDAO() {
        return new CustomerDAO(logger());
    }


}

//@Configuration
//public class AppConfig {
//    @Bean
//    public CustomerService customerService(){
//        CustomerService customerService = new CustomerServiceImpl();
//        customerService.setEmailService(emailService());
//        return customerService;
//    }
//    @Bean
//    public EmailService emailService(){
//        return new EmailServiceImpl();
//    }
//}