package uno.csci4830.mavitapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class MavitApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MavitApiApplication.class, args);
	}

}
