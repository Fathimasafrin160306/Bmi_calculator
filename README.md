# BMI Calculator Web Application

## Project Description

The BMI Calculator is a web-based application developed using Java Servlet, JDBC, HTML, and MySQL.

The application allows the user to enter their name, height, and weight. The Servlet calculates the Body Mass Index (BMI) and determines the corresponding BMI category. The entered details along with the calculated BMI and category are stored in a MySQL database using JDBC.

## Technologies Used

- Java
- Jakarta Servlet
- HTML
- JDBC
- MySQL
- MySQL Workbench
- Apache Tomcat
- Eclipse IDE

## Features

- User enters their name.
- User enters height in centimeters.
- User enters weight in kilograms.
- Calculates BMI automatically.
- Determines the BMI category.
- Stores user details in MySQL.
- Displays the calculated BMI and category.

## BMI Categories

| BMI Value | Category |
|-----------|----------|
| Below 18.5 | Underweight |
| 18.5 - 24.9 | Normal |
| 25 - 29.9 | Overweight |
| 30 and above | Obese |

## Project Structure

```text
BMICalculator
│
├── src
│   └── main
│       ├── java
│       │   └── bmi
│       │       └── BMIServlet.java
│       │
│       └── webapp
│           ├── index.html
│           └── WEB-INF
│               └── lib
│                   └── mysql-connector-j-26.7.0.jar
│
└── README.md
