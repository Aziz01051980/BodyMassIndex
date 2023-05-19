package myforexhelp.realtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories
public class RealtimeApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(RealtimeApplication.class, args);
		System.out.println("Application is running");
	}
}
