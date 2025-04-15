# Tetrahedron Project

## 📌 Description
This Java project implements a modular, well-structured application for modeling and analyzing tetrahedrons using a set of software design patterns. It includes:

- Geometry calculations
- Object creation, validation, and storage
- Reactive updates with observer pattern
- Filtering with specification pattern
- Logging and test coverage

---

## ✅ Implemented Design Patterns

| Pattern             | Implementation                                     |
|--------------------|-----------------------------------------------------|
| Factory Method      | `TetrahedronFactory` for safe object creation      |
| Observer            | `Tetrahedron`, `WarehouseObserver`, `TetrahedronEvent` |
| Singleton           | `Warehouse.getInstance()`                         |
| Object Pool         | `Warehouse` for parameter storage                 |
| Specification       | `Specification` interface + various filters       |
| Repository          | `TetrahedronRepository` with `query()` and `sort()` |

---

## 🧰 Technologies and Libraries Used

- Java 17+
- Maven
- SLF4J + Log4j2 (for logging)
- TestNG (for unit testing)

---

## 📁 Project Structure

```bash
tetrahedron
├── pom.xml
├── logs/
├── resources/
│   └── input.txt
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── epam
│   │               └── tetrahedron
│   │                   ├── entity
│   │                   ├── factory
│   │                   ├── action
│   │                   ├── validator
│   │                   ├── observer
│   │                   ├── repository
│   │                   ├── warehouse
│   │                   ├── reader
│   │                   ├── parser
│   │                   ├── util
│   │                   └── main
│   └── test
│       └── java
│           └── com.epam.tetrahedron (unit tests)
```

---

## 🔬 Unit Testing (TestNG)

| Test Class                 | Covered                                        |
|---------------------------|------------------------------------------------|
| `TetrahedronServiceTest`  | Volume, area, validity                         |
| `TetrahedronFactoryTest`  | Valid/invalid creation                         |
| `TetrahedronValidatorTest`| Geometry and list validation                   |
| `WarehouseObserverTest`   | Automatic parameter update via observer       |

To run tests:
```bash
mvn test
```

---

## 🧾 Logging

- Uses **SLF4J + Log4j2**
- Logs go to:
    - Console
    - File: `logs/app.log`
- All major components are covered

---

## 📄 How to Run

1. Place input file: `resources/input.txt`
2. Format of each line: 12 double values separated by `;`
   ```txt
   0;0;0; 1;0;0; 0;1;0; 0;0;1
   1;1;1; 2;2;2; 3;3;3; 4;4;4
   ```
3. Build and run project:
```bash
mvn clean compile exec:java -Dexec.mainClass="com.epam.tetrahedron.main.Main"
```

---

## 📦 Requirements

- Java 17+ (Java 22 supported)
- Maven

---

## 📃 Author
Denis Haidukevich
---

## 💡 Future Improvements

- CLI UI / GUI
- Javadoc and UML diagrams
- JSON/CSV input/output

