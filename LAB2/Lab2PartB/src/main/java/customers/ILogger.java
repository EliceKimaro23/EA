package customers;

import org.springframework.stereotype.Component;

@Component
public interface ILogger {
    void log (String logstring);
}
