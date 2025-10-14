# 🧠 TP Spring IoC et Injection de Dépendances

## 🎯 Objectif
Mettre en œuvre les principes d’**Inversion de Contrôle (IoC)** et d’**Injection de Dépendances (DI)** à l’aide de **Spring Framework**, en utilisant les **annotations** (`@Component`, `@Autowired`, `@Qualifier`, etc.).

L’application illustre comment Spring peut injecter automatiquement les dépendances entre plusieurs couches (`dao`, `metier`, `presentation`) sans couplage fort.

---

## ⚙️ Prérequis
- **Java JDK 24** (ou ≥ 11)
- **Apache Maven 3.9+**
- **VS Code** (avec *Extension Pack for Java*)
- **Spring Framework 6.x**

---

## 🏗️ Structure du projet

springdi/
├── src/
│ └── main/
│ └── java/
│ └── com/example/
│ ├── dao/
│ │ ├── IDao.java
│ │ ├── DaoImpl.java
│ │ └── DaoImpl2.java
│ ├── metier/
│ │ ├── IMetier.java
│ │ └── MetierImpl.java
│ └── presentation/
│ └── Presentation2.java
├── pom.xml
└── README.md


---

## 🧩 Description des packages

### 📦 `dao`
Contient les classes d’accès aux données :
- **`IDao`** : interface définissant la méthode `getValue()`
- **`DaoImpl`** : première implémentation retournant `100.0`
- **`DaoImpl2`** : deuxième implémentation retournant `150.0`

```java
@Component("dao")   // première implémentation
@Component("dao2")  // deuxième implémentation
⚙️ metier
Contient la logique métier :

IMetier : interface définissant la méthode calcul()

MetierImpl : classe implémentant IMetier
Injection du DAO via @Autowired et @Qualifier.


@Autowired
@Qualifier("dao2") // Choisit l'implémentation injectée
private IDao dao;
Méthode :


@Override
public double calcul() {
    return dao.getValue() * 2;
}
🖥️ presentation
Contient la classe principale Presentation2 :

Configure Spring avec @Configuration et @ComponentScan

Crée un contexte Spring basé sur les annotations

Récupère le bean IMetier et exécute calcul()

@Configuration
@ComponentScan(basePackages = {"com.example.springdi.dao", "com.example.springdi.metier"})
public class Presentation2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Presentation2.class);
        IMetier metier = context.getBean(IMetier.class);
        System.out.println("Résultat = " + metier.calcul());
    }
}
🧠 Principe démontré
IoC (Inversion de Contrôle) : l’objet MetierImpl ne crée pas lui-même son DAO, c’est le conteneur Spring qui s’en charge.

DI (Injection de Dépendance) : Spring choisit et injecte automatiquement le bon IDao selon les annotations.

🚀 Exécution du projet
Option 1 : depuis VS Code
Ouvre Presentation2.java

Clique sur ▶️ Run Java

Option 2 : via Maven

mvn clean compile
mvn -q exec:java -D"exec.mainClass=com.example.springdi.presentation.Presentation2"
🧾 Résultats attendus
Implémentation injectée	Valeur retournée par getValue()	Résultat de calcul()
@Qualifier("dao")	100.0	200.0
@Qualifier("dao2")	150.0	300.0

<img width="655" height="191" alt="image" src="https://github.com/user-attachments/assets/fabd524e-43ad-4312-b126-09a4b269fef7" />
<img width="649" height="76" alt="image" src="https://github.com/user-attachments/assets/e00989b2-6584-4d7b-9d2a-568e8377a1a7" />




🧰 Technologies utilisées
Java 24

Spring Framework 6.2

Maven 3.9

JUnit 5 (pour tests unitaires)

VS Code avec Maven for Java & Spring Tools

🧑‍💻 Auteur
Imane Aitmessaoud
💼 EMSI Marrakech
📅 TP : Spring IoC et Injection de dépendances
📧 imaneaitmessaoud56@gmail.com
