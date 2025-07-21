# 🚀 CoreJavaProj03 - Factory Pattern

This project demonstrates the **Factory Design Pattern** in Java. It creates different types of bikes using a centralized `BikeFactory` class. This design pattern helps decouple object creation logic from the client code, making the application more modular and maintainable.

---

## 📦 Project Structure

```

CoreJavaProj03-FactoryPattern
│
├── src
│   ├── com.nt.comps            # Contains bike components (interface + concrete classes)
│   │   ├── Bike.java
│   │   ├── BulletBike.java
│   │   ├── ElectricBike.java
│   │   ├── SportsBike.java
│   │   └── StandardBike.java
│   │
│   ├── com.nt.factory          # Contains the factory class
│   │   └── BikeFactory.java
│   │
│   └── com.nt.test             # Contains the test class
│       └── FactoryPatternTest.java

```

---

## ✅ Technologies Used

- Java 22
- Core Java (OOPs)
- Eclipse IDE (Recommended)

---

## 🧠 Key Concepts

- **Interface-Based Programming**
- **Loose Coupling**
- **Factory Design Pattern**
- **Encapsulation**

---

## 🔧 How It Works

1. `Bike.java` - An interface that declares the `drive()` method.
2. `BulletBike`, `ElectricBike`, `SportsBike`, `StandardBike` - Concrete classes implementing `Bike`.
3. `BikeFactory.java` - A factory class that returns an instance of a `Bike` based on the string input.
4. `FactoryPatternTest.java` - Demonstrates how to use the factory to create bike objects without coupling to the specific class names.

---

## ▶️ Sample Output

```

### StandardBike.drive():: driving StandardBike (Bajaj Discover)

### SportsBike.drive()::Driving SportsBike (Kawasaki - Ninja)

### ElectricBike.drive():: Driving ElectricBike (Ather Bike)

### BulletBike.drive():: driving BulletBike (Royal Enfield - Bullet)

```

---

## 📌 How to Run

1. Clone or download this project in your Java IDE (Eclipse/IntelliJ).
2. Make sure Java 17+ is installed (Java 22 preferred).
3. Run the `FactoryPatternTest.java` class.

---

## 🧹 Improvements to Explore

- Add support for more bike types.
- Read bike type from user input (Scanner).
- Return null instead of throwing exception (optional).
- Implement logging using a logger framework.

---

## 📚 References

- [Factory Pattern - GeeksforGeeks](https://www.geeksforgeeks.org/factory-method-design-pattern-in-java/)
- [Java Design Patterns](https://refactoring.guru/design-patterns/factory-method)

---
