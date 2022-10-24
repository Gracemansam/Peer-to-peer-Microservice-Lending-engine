package com.graceman.lendingengine;

import com.graceman.lendingengine.domain.model.User;
import com.graceman.lendingengine.domain.model.enums.UserRoles;
import com.graceman.lendingengine.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LendingEngineApplication implements CommandLineRunner {





    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(LendingEngineApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(User.builder().id(1L)
                .age(20)
                .email("email1@gmail.com")
                .Occupation("Software Engineer")
                .role(UserRoles.LENDER)
                .name("Grace")
                .build());
        userRepository.save(User.builder().id(2L)
                .age(28)
                .email("email2@gmail.com")
                .Occupation("Teacher")
                .role(UserRoles.BORROWER)
                .name("joe")
                .build());
        userRepository.save(User.builder().id(3L)
                .age(40)
                .email("email3@gmail.com")
                .Occupation("Engineer")
                .role(UserRoles.BORROWER)
                .name("Tolu")
                .build());


    }
}
