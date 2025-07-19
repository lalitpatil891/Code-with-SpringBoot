# 🧩 Solving the Ambiguity Problem in Spring Framework

When a class has multiple dependencies of the same type, Spring cannot decide which one to inject — this leads to an **ambiguity problem**.

This document covers:

- The root cause of ambiguity
- Solutions using `@Primary` and `@Qualifier`
- Best practices with annotations

---

## ⚠️ Problem: Ambiguous Dependency Injection

When a Spring bean depends on an interface that has **multiple implementations**, Spring throws a `NoUniqueBeanDefinitionException`.

```java
@Component
public class Vehicle {
    private Engine engine;

    @Autowired
    public Vehicle(Engine engine) {
        this.engine = engine; // ⚠️ Ambiguous: multiple Engine beans exist
    }
}
````

If you have:

```java
@Component("petrol")
public class PetrolEngine implements Engine {}

@Component("diesel")
public class DieselEngine implements Engine {}
```

Spring gets confused about which bean to inject into `Vehicle`.

---

## ✅ Solution 1: Use `@Primary` to Give Preference

Mark one of the beans as primary:

```java
@Component
@Primary
public class PetrolEngine implements Engine {}
```

Now Spring will always inject `PetrolEngine` unless otherwise specified.

---

## ✅ Solution 2: Use `@Qualifier` to Specify the Bean

You can resolve ambiguity by specifying the exact bean name:

```java
@Component
public class Vehicle {
    @Autowired
    @Qualifier("diesel")
    private Engine engine;
}
```

This tells Spring exactly which implementation to use.

---

## ⚔️ `@Primary` vs `@Qualifier`

| Feature     | `@Primary`                              | `@Qualifier`                            |
| ----------- | --------------------------------------- | --------------------------------------- |
| Scope       | Used at bean level                      | Used at injection point                 |
| Behavior    | Gives default preference to a bean      | Specifies exact bean to use             |
| Flexibility | Less flexible                           | Very specific and flexible              |
| Use Case    | Only one implementation is usually used | Multiple beans used in different places |

---

## 💡 Best Practice

Use `@Primary` when:

* One implementation is used 90% of the time.

Use `@Qualifier` when:

* You need to inject specific implementations.

---

## 📌 Example Code

```java
@Component
public class Vehicle {
    @Autowired
    @Qualifier("diesel") // use the diesel engine
    private Engine engine;
}

@Component("petrol")
@Primary
public class PetrolEngine implements Engine {}

@Component("diesel")
public class DieselEngine implements Engine {}
```

---

## ✅ Final Note

Spring is powerful, but when using multiple implementations of the same interface, you must **guide Spring** with either `@Primary` or `@Qualifier` to avoid runtime errors.


## 🖼 **Diagram**

![Primary & Qualifier](https://github.com/lalitpatil891/Code-with-SpringBoot/blob/main/SBMS/SpringCore/NTSPBMS718-%20Session14-Solving%20the%20Ambuity%20Problem.png)
