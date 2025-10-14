package com.example.metier;

import com.example.dao.IDao;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MetierImplTest {

    @Test
    void testCalcul() {
        // Faux DAO pour le test
        IDao fakeDao = () -> 10.0;

        // Metier + injection par setter
        MetierImpl metier = new MetierImpl(); // constructeur par défaut
        metier.setDao(fakeDao);

        // 10 * 2 = 20
        double result = metier.calcul();
        assertEquals(20.0, result, 0.001);
    }
}