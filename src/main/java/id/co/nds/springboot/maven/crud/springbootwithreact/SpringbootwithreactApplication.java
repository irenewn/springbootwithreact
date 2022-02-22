package id.co.nds.springboot.maven.crud.springbootwithreact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"id.co.nds.springboot.maven.crud.*"})
@EnableJpaRepositories(basePackages = {"id.co.nds.springboot.maven.crud.*"})
@EntityScan(basePackages = {"id.co.nds.springboot.maven.crud.*"})
public class SpringbootwithreactApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwithreactApplication.class, args);
	}

}
