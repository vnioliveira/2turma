package com.basis.campina.xtarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class XTarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(XTarefasApplication.class, args);
	}

}
