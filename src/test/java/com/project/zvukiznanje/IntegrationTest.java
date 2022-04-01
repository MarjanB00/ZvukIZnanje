package com.project.zvukiznanje;

import com.project.zvukiznanje.entity.users;
import com.project.zvukiznanje.repository.userRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;

@SpringBootTest(classes = ZvukIZnanjeApplication.class)
public class IntegrationTest {

    @Autowired
    private userRepository UserRepository;

    @Test
    public void insert(){
        users user = new users();
        user.setEmail("f@b.c");
        user.setLastName("aa");
        user.setName("bbb");
        user.setPassword("adsc");
        user.setDateOfCreation(null);


        UserRepository.save(user);
    }
}
