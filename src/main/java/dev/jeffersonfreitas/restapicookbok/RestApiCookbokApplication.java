package dev.jeffersonfreitas.restapicookbok;

import dev.jeffersonfreitas.restapicookbok.model.Customer;
import dev.jeffersonfreitas.restapicookbok.model.User;
import dev.jeffersonfreitas.restapicookbok.repository.CustomerRepository;
import dev.jeffersonfreitas.restapicookbok.repository.UserRepository;
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
	public ApplicationRunner run(CustomerRepository customerRepository, UserRepository userRepository) {
		return (ApplicationArguments args) -> {
			List<Customer> customers = Arrays.asList(
					new Customer().create("Jefferson Freitas", "AAAA33", LocalDate.of(1984, 06, 06)),
					new Customer().create("Antonio Moreira", "BBBB44", LocalDate.of(1984, 06, 06)),
					new Customer().create("Freitas Moreira", "CCCC55", LocalDate.of(1984, 06, 06))
			);

			User user = new User().create("jefferson", "abcABC123*");
			customerRepository.saveAll(customers);
			userRepository.save(user);
		};
	}

}
