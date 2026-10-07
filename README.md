# 🍕 PizzaHub - Maven Java Version

This is the Java/Maven conversion of the original PizzaHub HTML/CSS/JavaScript project.

## Technology Stack

- Java 17
- Spring Boot 3.5.6
- Maven
- Thymeleaf
- HTML5
- CSS3

The business logic has been moved from JavaScript into Java service classes and Spring MVC controllers.

## Maven Project Structure

```text
pizza-order-system/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/com/pizzahub/
    │   │   ├── PizzaHubApplication.java
    │   │   ├── controller/
    │   │   │   ├── HomeController.java
    │   │   │   ├── OrderController.java
    │   │   │   ├── BillingController.java
    │   │   │   └── TrackingController.java
    │   │   ├── model/
    │   │   │   ├── Pizza.java
    │   │   │   ├── Order.java
    │   │   │   └── Bill.java
    │   │   └── service/
    │   │       ├── PizzaService.java
    │   │       ├── OrderService.java
    │   │       └── BillingService.java
    │   └── resources/
    │       ├── application.properties
    │       ├── static/css/style.css
    │       └── templates/
    │           ├── index.html
    │           ├── order.html
    │           ├── billing.html
    │           └── track.html
    └── test/
```

## Main Features

1. Home page with pizza menu and offers.
2. Place pizza order.
3. Quantity calculation.
4. `SAVE20` coupon for 20% discount.
5. 5% GST calculation.
6. Automatic Order ID generation.
7. Bill generation with 5% GST.
8. Order tracking.
9. Maven build and Spring Boot execution.

## Important Correction

The original JavaScript had Margherita priced at `₹5000` on the order page while the home page showed `₹250`. The Java version uses `₹250`, which is consistent with the home page and the project description.

## Requirements

Install:

- JDK 17 or newer
- Maven 3.9+ recommended

Check:

```powershell
java -version
mvn -version
```

## Run Using Maven

Open PowerShell in the project root:

```powershell
cd path	o\pizza-order-system
mvn clean package
mvn spring-boot:run
```

Then open:

```text
http://localhost:8081
```

## Run the JAR

After:

```powershell
mvn clean package
```

run:

```powershell
java -jar target/pizza-order-system-1.0.0.jar
```

Then open:

```text
http://localhost:8081
```

## IntelliJ / Eclipse / VS Code

Import/open the folder containing `pom.xml` as a Maven project.

Main class:

```text
com.pizzahub.PizzaHubApplication
```

Run that class to start the application.

## Notes

Orders are stored in memory for this educational/demo version. Restarting the application clears the orders. A database can be added later using Spring Data JPA/MySQL.

The order tracking status is intentionally randomized to preserve the demo behavior of the original JavaScript version.
