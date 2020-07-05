package com.example.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {

        return args -> {
          log.info("Preloading " + repository.save(new Employee("Eren Yeager", "Shitty protagonist")));
          log.info("Preloading " + repository.save(new Employee("Mikasa Ackerman", "Waifu")));
          log.info("Preloading " + repository.save(new Employee("Levi Ackerman", "Rolemodel")));
        };
    }
}
