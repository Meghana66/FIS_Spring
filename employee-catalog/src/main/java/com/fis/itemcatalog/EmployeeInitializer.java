package com.fis.itemcatalog;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class EmployeeInitializer implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    EmployeeInitializer(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Meghana", "Pranitha", "Bhuvan", "Arun kumar", "Nikki", "Aditya", "Reshma")
                .forEach(item -> employeeRepository.save(new Employee(item)));

        employeeRepository.findAll().forEach(System.out::println);
    }
}
