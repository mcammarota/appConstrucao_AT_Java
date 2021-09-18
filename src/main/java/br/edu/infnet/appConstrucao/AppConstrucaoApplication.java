package br.edu.infnet.appConstrucao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppConstrucaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppConstrucaoApplication.class, args);
	}

}
