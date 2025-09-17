# SpringXmlInjectionDemo

A simple Spring project that demonstrates **constructor injection** and **setter injection** using XML configuration.  
This helps you understand how Spring IoC (Inversion of Control) container manages beans and their dependencies.

---

## 📦 **Project structure**

```

SpringXmlInjectionDemo/
├── src/
│   └── com/example/beans/
│       └── WishMessageGenerator.java
│   └── com/example/test/
│       └── ClientApp.java
└── resources/
└── applicationContext.xml

```

---

## 🌱 **How it works (simple diagram)**

```

+-------------------------------------------------+
\| Spring IoC container                      |
\| (created using ClassPathXmlApplicationContext) |
+-------------------------------------------------+
|
v
Reads beans from applicationContext.xml
|
v
+-------------------------------------------+
\| Creates WishMessageGenerator bean         |
\| 1️⃣ Constructor injection:                |
\|    time = currentTime                     |
\|    date = currentDate                     |
+-------------------------------------------+
|
v
+-------------------------------------------+
\| 2️⃣ Setter injection:                     |
\|    setTime(currentTime)                    |
\|    setDate(currentDate)                    |
\| (Overrides earlier values)                |
+-------------------------------------------+
|
v
+-------------------------------------------+
\| Use the bean in ClientApp                 |
\| Call: generateWish("Lalit")               |
+-------------------------------------------+

```

---

## ✅ **Explanation of the main parts**

### `WishMessageGenerator.java`
- Depends on `LocalTime` and `LocalDate`.
- Has:
  - Constructor for constructor injection.
  - Setter methods for setter injection.
- Generates a message like:  
  `"Good Morning, Lalit! Today's date: 2025-06-30"`

---

### `applicationContext.xml`
- Defines:
  - Beans for `LocalTime` and `LocalDate` using factory-method `now()`.
  - Target bean `wishBean` using both constructor and setter injection.

---

### `ClientApp.java`
- Loads Spring container.
- Gets `wishBean`.
- Calls method to print wish message.

---

## 🧪 **Expected output**
```

WishMessageGenerator: constructor called
WishMessageGenerator: setTime() called
WishMessageGenerator: setDate() called
Good Morning, Lalit! Today's date: 2025-06-30

```

---

## 🛠 **Technologies used**
- Java
- Spring Framework (Core)
- Eclipse IDE
