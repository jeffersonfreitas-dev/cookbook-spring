package dev.jeffersonfreitas.restapicookbok;

import dev.jeffersonfreitas.restapicookbok.model.Customer;
import dev.jeffersonfreitas.restapicookbok.repository.CustomerRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RestApiCookbokApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiCookbokApplication.class, args);
	}

	@Bean
	public ApplicationRunner run(CustomerRepository repository) {
		return (ApplicationArguments args) -> {
			List<Customer> customers = Arrays.asList(
					new Customer().create("Jefferson Freitas", "AAAA33", LocalDate.of(1984, 06, 06)),
					new Customer().create("Antonio Moreira", "BBBB44", LocalDate.of(1984, 06, 06)),
					new Customer().create("Freitas Moreira", "CCCC55", LocalDate.of(1984, 06, 06))
			);
			repository.saveAll(customers);
		};
	}

}
