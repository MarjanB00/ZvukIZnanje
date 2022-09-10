package com.project.zvukiznanje.dao;

import lombok.Data;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;


@Data
public class FileDAO {

    private byte[] File;
    private String name;

}
