package com.wbarcellosn.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.wbarcellosn.entities.Cliente;
import com.wbarcellosn.repository.IClienteRepository;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "com.wbarcellosn.repository")
@EntityScan("com.wbarcellosn.*")  
@ComponentScan(basePackages = "com.wbarcellosn")
public class ExercicioM40Application implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(ExercicioM40Application.class);

	@Autowired
	private IClienteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ExercicioM40Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("StartApplication...");
		Cliente cliente = createCliente();
		repository.save(cliente);
		
	}

	private Cliente createCliente() {
		
		return Cliente.builder()
				.nome("Winicius Barcellos")
				.cpf(12345678900L)
				.email("winicius@teste.com")
				.tel(10203040L)
				.end("Rua A")
				.cidade("Vitória")
				.estado("ES")
				.numero(15)
				.build();
	}

}
