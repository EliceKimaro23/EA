package customers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		IProductService productService = context.getBean("productService", IProductService.class);

		productService.addPoduct("Apple", "fbrown@acme.com", 45.00);

	}


}
