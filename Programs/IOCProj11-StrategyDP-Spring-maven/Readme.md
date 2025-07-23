# 🧠 Strategy Design Pattern with Spring Framework

This project demonstrates the **Strategy Design Pattern** implementation using **Spring Framework (Java)**. It promotes loose coupling and dynamic behavior selection at runtime.

---

## 📚 What is the Strategy Pattern?

The **Strategy Pattern** is a behavioral design pattern that enables selecting an algorithm’s behavior at runtime. Instead of implementing a single algorithm directly, code receives run-time instructions to choose among a family of algorithms.

---

## 📦 Project Structure

```
com.nt.sbeans
├── Courier.java            // Interface
├── BlueDartImpl.java       // Implementation 1
├── DTDCImpl.java           // Implementation 2
├── FedExImpl.java          // Implementation 3
├── Flipkart.java           // Dependent class (uses Courier)
```

---

## 🛠️ Key Components

### 1. **Courier.java**

An interface defining the contract for courier services:

```java
public interface Courier {
    public String deliver(int oid);
}
```

---

### 2. **FedExImpl.java / DTDCImpl.java / BlueDartImpl.java**

Implementations of `Courier`:

```java
@Component("fedEx")
public class FedExImpl implements Courier {
    public String deliver(int oid) {
        return oid + " order is delivered by FedEx";
    }
}
```

---

### 3. **Flipkart.java**

A class that uses the `Courier` interface. Spring will inject the appropriate implementation.

```java
@Component("fpkt")
public class Flipkart {
    @Autowired
    private Courier courier; // Interface type

    public String shopping(String[] items, double[] prices) {
        double billAmt = Arrays.stream(prices).sum();
        int oid = new Random().nextInt(1000);
        String status = courier.deliver(oid);
        return Arrays.toString(items) + " are purchased having prices " +
                Arrays.toString(prices) + " with bill amount " + billAmt + " --> " + status;
    }
}
```

---

## 🧩 Spring Configuration

### AppConfig.java (Java-based Configuration)

```java
@Configuration
@ComponentScan(basePackages = "com.nt.sbeans")
public class AppConfig {
}
```

---

## 🚀 Execution

### MainApp.java

```java
public class StrategyDPTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Flipkart fpkt = ctx.getBean("fpkt", Flipkart.class);
        String result = fpkt.shopping(new String[]{"shirt", "trouser", "watch"}, new double[]{1000, 3000, 5000});
        System.out.println(result);
    }
}
```

---

## 💡 Output Example

```
[shirt, trouser, watch] are purchased having prices [1000.0, 3000.0, 5000.0] with bill amount 9000.0 --> 871 order is delivered by DTDC
```

---

## 🔁 How Strategy Pattern Works Here

* `Courier` is the strategy interface.
* `FedExImpl`, `DTDCImpl`, and `BlueDartImpl` are concrete strategies.
* `Flipkart` is the context using the strategy.
* Spring injects one of the strategies dynamically.

---

## 📝 Notes

* Uses **Spring’s @Component and @Autowired** for dependency injection.
* Demonstrates **loose coupling** between `Flipkart` and courier service implementations.
* You can easily switch between different courier implementations via bean naming or qualifier.

---

## 🏁 How to Run

1. Clone the repo.
2. Use an IDE like IntelliJ or Eclipse.
3. Add Spring Context dependency.
4. Run the `StrategyDPTest.java` class.

---

## 🧠 Diagram

![Strategy Pattern Diagram](https://refactoring.guru/images/patterns/content/strategy/strategy.png)
