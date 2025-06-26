# Spring Dependency Injection Example (XML Configuration)

This is a basic Spring Framework project demonstrating **Dependency Injection (DI)** using **XML-based configuration**.

## 🧾 Overview

The project defines two main components:
- A **dependent bean** (`LocalTime` from Java 8 Time API)
- A **target bean** (`WishMessageGenerator`) that uses the dependent bean to generate a time-based wish message.

Spring IoC (Inversion of Control) container is configured through an XML file to wire these beans together.

---

## 🗂️ Project Structure

```

spring-di-xml/
│
├── src/
│   └── com/
│       └── nt/
│           ├── main/
│           │   └── DependencyInjectionTest.java
│           └── sbeans/
│               └── WishMessageGenerator.java
│
├── src/com/nt/cfgs/
│   └── applicationContext.xml
│
└── README.md

```

---

## 🔧 How It Works

1. `applicationContext.xml` defines two beans:
   - A `LocalTime` object using a factory method (`now()`).
   - A `WishMessageGenerator` bean that receives the `LocalTime` bean as a dependency.

2. The `WishMessageGenerator` uses this time value to generate a wish message such as "Good Morning", "Good Afternoon", etc.

3. `DependencyInjectionTest` is the main class that loads the Spring context, retrieves the bean, and prints the message.

---

## 🧪 How to Run

1. Clone or download the project.
2. Make sure you have JDK 8+ and Spring Core libraries added to your project classpath.
3. Compile and run `DependencyInjectionTest.java`.

---

## 📝 Sample Output

```

Good Morning Raja

````

*(Output may vary depending on the current system time)*

---

## 📦 Dependencies

- Java 8 or above
- Spring Core (spring-context, spring-beans)

---

## 📁 XML Configuration

```xml
<bean id="ltime" class="java.time.LocalTime" factory-method="now" />

<bean id="wmg" class="com.nt.sbeans.WishMessageGenerator">
    <property name="time" ref="ltime" />
</bean>
````
