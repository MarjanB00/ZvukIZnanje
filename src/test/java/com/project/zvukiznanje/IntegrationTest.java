package com.project.zvukiznanje;
import com.project.zvukiznanje.entity.users;
import com.project.zvukiznanje.repository.usersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;

@SpringBootTest(classes = ZvukIZnanjeApplication.class)
public class IntegrationTest {

    Logger logger = Logger.getLogger(String.valueOf(IntegrationTest.class));

    @Autowired
    private usersRepository UserRepository;

    @Test
    public void insert() {
       users user= UserRepository.findByEmail("test@mail.com");
        //logger.info(String.valueOf(user));
    }
}
