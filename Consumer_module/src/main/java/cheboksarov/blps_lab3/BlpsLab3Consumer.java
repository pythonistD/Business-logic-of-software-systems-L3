package cheboksarov.blps_lab3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlpsLab3Consumer {

	public static void main(String[] args) {
		SpringApplication.run(BlpsLab3Consumer.class, args);

	}
	//todo Auto-generate admin, betmaster, statisticsmaster
	/*@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService authenticationService
	){
		return args -> {
			authenticationService.register(
					RegisterRequestDto.builder()
							.username("admin")
							.password("123qwe")
							.firstName("Yaroslav")
							.lastName("Cheboksarov")
							.build()
			)
		};

	}*/

}
