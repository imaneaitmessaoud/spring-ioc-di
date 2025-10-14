package com.example.presentation;

import com.example.metier.IMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresentationXML {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("applicationContext.xml")) {

            IMetier metier = context.getBean(IMetier.class);
            System.out.println("Résultat (XML) = " + metier.calcul());
        }
    }
}
