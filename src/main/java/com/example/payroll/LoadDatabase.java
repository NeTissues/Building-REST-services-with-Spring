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
    CommandLineRunner initDatabase(EmployeeRepository EmployeeRepository, OrderRepository OrderRepository) {

        return args -> {

            EmployeeRepository.save(new Employee("Eren", "Yeager", "MC"));
            EmployeeRepository.save(new Employee("Mikasa", "Ackerman", "MC"));
            EmployeeRepository.save(new Employee("Armin", "Arlert", "MC"));

            EmployeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

            OrderRepository.save(new Order("3D manouver gear", Status.COMPLETED));
            OrderRepository.save(new Order("Blades", Status.IN_PROGRESS));

            OrderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });

        };
    }
}
