package ac.linker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LinkerApplication {

	public static void main(String[] args) {
		System.out.println("###################server start###################");
		SpringApplication.run(LinkerApplication.class, args);
	}

}
