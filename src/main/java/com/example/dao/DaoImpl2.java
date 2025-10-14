package com.example.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("dao2")
@Profile("dev") // actif uniquement si profil 'dev'
public class DaoImpl2 implements IDao {
    @Override
    public double getValue() {
        System.out.println("Version de développement");
        return 150.0;
    }
}
