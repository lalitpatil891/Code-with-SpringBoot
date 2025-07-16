## **📝 Working with @Autowired to perform different types of Dependency Injection**

### 🔹 Overview

Spring Framework’s `@Autowired` annotation allows automatic dependency injection in various ways:

* **Field injection**
* **Setter method injection**
* **Arbitrary method injection**
* **Constructor injection**

---

### ✅ **1️⃣ Field injection using @Autowired**

```java
@Component("seasonFinder")
public class SeasonFinder {

   @Autowired  // field injection
   private LocalDateTime ldt;

   public String showSeason() {
       int month = ldt.getMonthValue();
       if(month >= 3 && month <= 6) return "Summer";
       else if(month >= 7 && month <= 10) return "Rainy";
       else return "Winter";
   }
}
```

**applicationContext.xml**

```xml
<context:component-scan base-package="com.nt.beans"/>
<bean id="ldt" class="java.time.LocalDateTime" factory-method="now"/>
```

---

### ✅ **2️⃣ Setter method injection using @Autowired**

```java
@Component("seasonFinder")
public class SeasonFinder {

   private LocalDateTime ldt;

   @Autowired
   public void setLdt(LocalDateTime ldt) {
       this.ldt = ldt;
   }

   public String showSeason() {
       int month = ldt.getMonthValue();
       if(month >= 3 && month <= 6) return "Summer";
       else if(month >= 7 && month <= 10) return "Rainy";
       else return "Winter";
   }
}
```

---

### ✅ **3️⃣ Arbitrary method injection using @Autowired**

```java
@Component("seasonFinder")
public class SeasonFinder {

   private LocalDateTime ldt;

   @Autowired
   public void assign(LocalDateTime ldt) {
       this.ldt = ldt;
   }

   public String showSeason() {
       int month = ldt.getMonthValue();
       if(month >= 3 && month <= 6) return "Summer";
       else if(month >= 7 && month <= 10) return "Rainy";
       else return "Winter";
   }
}
```

---

### ✅ **4️⃣ Constructor injection using @Autowired**

```java
@Component("seasonFinder")
public class SeasonFinder {

   private LocalDateTime ldt;

   @Autowired
   public SeasonFinder(LocalDateTime ldt) {
       this.ldt = ldt;
   }

   public String showSeason() {
       int month = ldt.getMonthValue();
       if(month >= 3 && month <= 6) return "Summer";
       else if(month >= 7 && month <= 10) return "Rainy";
       else return "Winter";
   }
}
```

---

## 🧠 **Important notes**

* You can place `@Autowired` on: field, setter, constructor, or arbitrary method.
* Avoid using `@Autowired` on multiple constructors (causes exception).
* By default, `@Autowired` works by type (type-based injection).
* Recommended approach: **Constructor injection** (promotes immutability & easier testing).

---

## 🖼 **Diagram**

![Autowired Injection Types](https://github.com/lalitpatil891/Code-with-SpringBoot/blob/main/SBMS/SpringCore/NTSPBMS718-%20Session12-Spring%20App%20development%20using%20xml%2Bannotation%20driven%20cfgs%20.png)
