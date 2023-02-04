package net.thrymr;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrganisationApplication implements CommandLineRunner {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(OrganisationApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}