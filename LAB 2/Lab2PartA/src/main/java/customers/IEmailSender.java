package customers;

import org.springframework.stereotype.Component;

@Component
public interface IEmailSender {
	void sendEmail(String email, String message);
	String getOutgoingMailServer();
}