# ✅ 100% Code-Based Configuration in Spring (No XML)
---

## 🚀 Objective

Develop a **Spring application using only Java-based configuration**, without any `applicationContext.xml`, demonstrating dependency injection and component scanning using annotations.

---

## 📌 Key Concepts Covered

* `@Configuration` and `@ComponentScan` for config setup
* `@Bean` to define non-component Spring beans
* `@Component` to auto-detect and register beans
* `@Autowired` for dependency injection
* `AnnotationConfigApplicationContext` as the Spring container

---

## 📦 Package Structure

```
src/
├── com/
│   └── nit/
│       ├── config/
│       │   └── AppConfig.java
│       ├── sbeans/
│       │   └── WeekDayFinder.java
│       └── main/
│           └── DependencyInjectionTest.java
```

---

## 🧩 Source Code

### ✅ AppConfig.java

```java
package com.nit.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.nit.sbeans")
public class AppConfig {

    public AppConfig() {
        System.out.println("AppConfig:: 0-param Constructor");
    }

    @Bean(name = "ldate")
    public LocalDate createLDate() {
        System.out.println("AppConfig.createDate()");
        return LocalDate.now();
    }
}
```

---

### 🌞 WeekDayFinder.java

```java
package com.nit.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wf")
public class WeekDayFinder {

    @Autowired
    private LocalDate date;

    public WeekDayFinder() {
        System.out.println("WeekDayFinder::0-paramConstructor");
    }

    public String showGreetMessage(String name) {
        System.out.println("WeekDayFinder.showGreetMessage()");

        int week = date.getDayOfWeek().getValue();

        if (week != 6 && week != 7)
            return "Happy working day, Working is Worshiping::" + name;
        else
            return "Happy Weekend, Enjoy your paid Holiday " + name;
    }
}
```

---

### 🧪 DependencyInjectionTest.java

```java
package com.nit.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.nit.config.AppConfig;
import com.nit.sbeans.WeekDayFinder;

public class DependencyInjectionTest {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {

            WeekDayFinder finder = ctx.getBean("wf", WeekDayFinder.class);
            System.out.println("Result::" + finder.showGreetMessage("raja"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## 🖥️ Output Sample

```
AppConfig:: 0-param Constructor
AppConfig.createDate()
WeekDayFinder::0-paramConstructor
WeekDayFinder.showGreetMessage()
Result::Happy working day, Working is Worshiping::raja
```

(Note: The message will change based on the current system date.)

---

## 🧾 Summary

| Feature              | Used in Code                         |
| -------------------- | ------------------------------------ |
| Java Config          | `@Configuration`                     |
| Component Scanning   | `@ComponentScan`                     |
| Bean Registration    | `@Bean`                              |
| Dependency Injection | `@Autowired`                         |
| Bean Lifecycle       | Java objects + DI container          |
| Testing the Bean     | `AnnotationConfigApplicationContext` |

---

## 📌 Advantages of Code-Based Config

* No XML maintenance
* Better type-safety and IDE support
* Easy for modularization and testability
* More aligned with Spring Boot style
