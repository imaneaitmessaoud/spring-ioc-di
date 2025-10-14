package com.example.metier;

import com.example.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")  // Bean Spring nommé "metier"
public class MetierImpl implements IMetier {

    // Injection automatique de l’implémentation de IDao
    @Autowired
    @Qualifier("dao") // tu peux choisir "dao" ou "dao2"
    // @Qualifier("dao2")
    private IDao dao;

    @Override
    public double calcul() {
        // Utilise le DAO injecté pour obtenir une valeur et la multiplier
        return dao.getValue() * 2;
    }

    // Setter (optionnel) pour injection par setter
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
