# 🌱 Spring Dependency Injection Example - Season Finder

This simple Spring application demonstrates **Dependency Injection (DI)** and **Inversion of Control (IoC)** using XML configuration.

The project:
- Finds the current month
- Decides the season based on that month
- Shows a friendly message to the user

---

## 📦 **Project Structure**
```plaintext
com.nit.sbeans.SeasonFinder            # Bean that finds season
com.nit.main.DependencyInjectionTest   # Main class to run the program
com/nit/cfgs/applicationContext.xml    # Spring configuration file
````

---

## ⚙️ **How It Works (Explanation)**

1. Spring reads the XML config: `applicationContext.xml`.

2. Creates a bean `ltime`:

   ```xml
   <bean id="ltime" class="java.time.LocalDate" factory-method="now" />
   ```

   → This creates the current date using `LocalDate.now()`.

3. Creates a bean `cmonth` (of type `SeasonFinder`) and injects the date:

   ```xml
   <bean id="cmonth" class="com.nit.sbeans.SeasonFinder">
       <property name="month" ref="ltime" />
   </bean>
   ```

   → Spring calls the setter `setMonth(LocalDate month)` and injects `ltime`.

4. The main program (`DependencyInjectionTest`) loads Spring context, gets the `SeasonFinder` bean, and calls:

   ```java
   season.showSeasonMessage("Lalit")
   ```

   → Returns a message with season and month.

---

## 🧩 **What is Dependency Injection?**

Instead of creating the date inside the `SeasonFinder` class (e.g., `LocalDate.now()`),
we ask Spring to create it **outside** and provide (inject) it via the setter.

✅ This is called:

* **Dependency Injection (DI):** dependencies are given to the object instead of the object creating them.
* **Inversion of Control (IoC):** control of object creation and wiring is inverted to the container (Spring).

---

## 📊 **Visual Flow (Text Diagram)**

```plaintext
+--------------------------------------------------+
|               applicationContext.xml             |
+--------------------------------------------------+
| <bean id="ltime"                                 |
|       class="java.time.LocalDate"                |
|       factory-method="now" />                     |
|                                                  |
| <bean id="cmonth"                                |
|       class="com.nit.sbeans.SeasonFinder">       |
|    <property name="month" ref="ltime" />         |
| </bean>                                          |
+--------------------------------------------------+

           |
           | Spring reads config & creates beans
           v

+-----------------------------------+
| Spring IoC Container              |
+-----------------------------------+
| Creates 'ltime' (LocalDate.now()) |
| Creates 'cmonth' (SeasonFinder)   |
| Calls setMonth(ltime)             |
+-----------------------------------+

           |
           | Application runs
           v

+---------------------------------------------+
| DependencyInjectionTest (main method)       |
+---------------------------------------------+
| Loads Spring context                        |
| Gets SeasonFinder bean                      |
| Calls showSeasonMessage("Lalit")            |
| Prints: Hey Lalit, Season: Summer, Month: 6 |
+---------------------------------------------+
```

---

## ▶ **Execution Flow**

1. Run `DependencyInjectionTest`.
2. Spring loads config and creates beans.
3. Injects `LocalDate` into `SeasonFinder`.
4. Call method to get message.
5. Print message to console.

---

## ✅ **Result (Example)**

```plaintext
Hey Lalit, Season: Summer, Month: 6
```

---

## ✏ **Why Use DI?**

* Makes code cleaner & easier to test.
* `SeasonFinder` does **not care** how to get the current date.
* We can easily change the date source in config (e.g., fixed date for testing).

---

> 📌 This project is a good starting point to learn how Spring handles bean creation and wiring using XML.
