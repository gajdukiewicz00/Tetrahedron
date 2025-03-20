# Tetrahedron Project

This project calculates the volume and surface area of a tetrahedron based on given coordinates. It includes utility classes for reading input from files and performing calculations. The project follows best practices for OOP and uses TestNG for testing.

## Technologies and Libraries Used
- Java 8
- Maven
- Log4J2 (for logging)
- TestNG (for testing)

## Project Structure
```
tetrahedron
├── pom.xml
├── logs
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
└── .gitignore
```

## Installation and Running
Clone the repository and build the project using Maven:
```bash
git clone https://github.com/gajdukiewicz00/Tetrahedron.git
cd Tetrahedron
mvn clean install
```

## Running Tests
Execute the tests using Maven:
```bash
mvn test
```

## Logging
Logs are stored in the `logs/` directory and printed to the console.
