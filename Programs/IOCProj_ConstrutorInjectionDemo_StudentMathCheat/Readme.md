# 🧠 Spring Constructor Injection Example

This project demonstrates how to use **Constructor-Based Dependency Injection** in a Spring Core application using XML configuration.

## 📂 Project Structure

```

spring-constructor-injection/
├── src/
│   ├── com/nit/sbeans/
│   │   ├── Student.java
│   │   └── MathCheat.java
│   ├── com/nit/main/
│   │   └── Main.java
│   └── com/nit/cfgs/
│       └── applicationContext.xml

````

---

## 🚀 Description

- `Student` depends on `MathCheat` to perform the cheating operation.
- Spring injects the `MathCheat` bean into `Student` using **constructor injection**.
- This project uses **XML-based Spring configuration**.

---

## 🧾 Technologies Used

- Java 8+
- Spring Framework (Core Container)
- XML Configuration

---

## 🔧 How It Works

### 1. Define Beans in XML

```xml
<bean id="mathCheatObjectValue" class="com.nit.sbeans.MathCheat"/>
<bean id="student" class="com.nit.sbeans.Student">
    <constructor-arg name="id" value="101"/>
    <constructor-arg name="mathCheat" ref="mathCheatObjectValue"/>
</bean>
````

### 2. Spring Container Loads Beans

```java
ApplicationContext ctx =
    new FileSystemXmlApplicationContext("src/com/nit/cfgs/applicationContext.xml");
```

### 3. Output

```
My ID is: 101
And I Have Started Math Cheating
```

---

## 📘 Classes Explained

### ✅ Student.java

* Has an `id` and a `MathCheat` dependency.
* Constructor is used for injection.
* Method `cheating()` calls `mathCheating()`.

### ✅ MathCheat.java

* Contains method `mathCheating()` that prints cheating logic.

---

## 💡 Learning Outcome

This project helps you learn:

* How Spring handles **constructor-based dependency injection**
* How to configure beans using **XML**
* How the Spring container manages and injects dependencies

---
