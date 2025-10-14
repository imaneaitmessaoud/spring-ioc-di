package com.example.dao;

import org.springframework.stereotype.Component;

@Component("dao")  // Déclare cette classe comme un bean Spring nommé "dao"
public class DaoImpl implements IDao {
    @Override
    public double getValue() {
        // Exemple simple
        return 100.0;
    }
}