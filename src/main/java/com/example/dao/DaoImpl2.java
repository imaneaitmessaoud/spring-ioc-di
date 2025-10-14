package com.example.dao;

import org.springframework.stereotype.Component;

@Component("dao2")  // autre identifiant
public class DaoImpl2 implements IDao {
    @Override
    public double getValue() {
        return 150.0;
    }
}
