# 🌦️ Season Finder - Spring Dependency Injection Example (XML Based)

This is a simple Java project demonstrating **Spring Framework's Dependency Injection (DI)** using an XML configuration file. It determines the **season** (Winter, Summer, or Rainy) based on the current month using the `java.time.LocalDate` class.

---

## 📁 Project Structure

```

src/
├── com/
│   └── nit/
│       ├── main/
│       │   └── DependencyInjectionTest.java
│       └── sbeans/
│           └── SeasonFinder.java
└── com/
└── nit/
└── cfgs/
└── applicationContext.xml

````

---

## 🚀 How It Works

### ➤ XML Configuration (`applicationContext.xml`)

- A bean of `java.time.LocalDate` is created using the factory method `now()` to inject the current date.
- The `SeasonFinder` bean is created and injected with this date via setter injection.

```xml
<bean id="ltime" class="java.time.LocalDate" factory-method="now" />
<bean id="cmonth" class="com.nit.sbeans.SeasonFinder">
    <property name="month" ref="ltime" />
</bean>
````

---

### ➤ Java Bean (`SeasonFinder.java`)

* Accepts a `LocalDate` instance injected by Spring.
* Extracts the current month and returns a message describing the **season**.

```java
public String showSeasonMessage(String user) {
    int currMonth = getMonth();

    if ((currMonth >= 11 && currMonth <= 12) || (currMonth >= 1 && currMonth <= 2)) {
        return "Hey " + user + ", Season: Winter, Month: " + currMonth;
    } else if (currMonth >= 3 && currMonth <= 6) {
        return "Hey " + user + ", Season: Summer, Month: " + currMonth;
    } else if (currMonth >= 7 && currMonth <= 10) {
        return "Hey " + user + ", Season: Rainy, Month: " + currMonth;
    } else {
        return "Hey " + user + ", Invalid Month!";
    }
}
```

---

### ➤ Main Class (`DependencyInjectionTest.java`)

* Loads the Spring container from XML.
* Retrieves the `SeasonFinder` bean.
* Calls `showSeasonMessage("Lalit")` and prints the result.

```java
SeasonFinder season = (SeasonFinder) fac.getBean("cmonth");
String sea = season.showSeasonMessage("Lalit");
System.out.println(sea);
```

---

## 💡 Key Concepts Used

* ✅ Spring Core - Bean Configuration using XML
* ✅ Factory Method for Date Injection (`LocalDate.now()`)
* ✅ Setter-based Dependency Injection
* ✅ Java 8+ `LocalDate` for current date
* ✅ Seasonal Logic using if-else blocks

---

## 🧪 Output Example

```
Hey Lalit, Season: Rainy, Month: 6
```

*(Output depends on current month when you run the program)*

---

## 📦 Requirements

* Java 8 or above
* Spring Framework (Core JARs)
* IDE like Eclipse / IntelliJ or simple terminal

---

## 📌 Notes

* This project uses **manual XML configuration**. In real-world Spring Boot projects, this is typically replaced by annotations (`@Component`, `@Autowired`) and Java-based config.
* Still, this is a great way to understand the **Spring IoC (Inversion of Control) Container** and how it manages object creation and wiring.

---

## 🙋 Author

**Lalit Patil**
Java Full Stack Developer
📬 [lalitpatil8901@gmail.com](mailto:lalitpatil8901@gmail.com)
🔗 [Portfolio](https://lalitpatil891.github.io/LalitPortfolio/) | [GitHub](https://github.com/lalitpatil891)

---
