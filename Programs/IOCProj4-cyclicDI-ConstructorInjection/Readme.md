## 🌀 Cyclic Dependency Example in Spring (Constructor Injection)

This project demonstrates what happens when you configure two Spring beans (`A` and `B`) to depend on each other via **constructor injection**, resulting in a **cyclic dependency problem**.

---

### 📂 Project Structure

```
src/
 ├── com/nit/sbeans/
 │   ├── A.java
 │   └── B.java
 ├── com/nit/main/
 │   └── CyclicInjectionTest.java
 └── com/nit/config/
     └── ApplicationContext.xml
```

---

### ⚙️ What happens?

* **A** has a constructor dependency on **B**
* **B** has a constructor dependency on **A**
* In the Spring configuration (`ApplicationContext.xml`), both are wired via constructor injection.
* When you run the application, Spring fails to create the beans because it **cannot resolve the circular dependency** through constructors:

  ```
  Caused by: org.springframework.beans.factory.BeanCreationException:
  Error creating bean with name 'b1' ... Cannot resolve reference to bean 'a1' while setting constructor argument
  ```

---

### ✅ How to run

1. Clone/download this project.
2. Make sure you have:

   * Java (8 or higher)
   * Spring core libraries on your classpath
3. Run the `CyclicInjectionTest` main class.

---

### 🧠 Why this fails

Spring **cannot handle cyclic dependencies** when beans are injected via constructors because:

* It needs to create an instance of `A` → which needs `B`
* But to create `B`, it again needs `A`
* This forms a loop before either bean is fully created.

---

### ✔️ How to fix

To resolve circular dependencies in Spring:

* Replace **constructor injection** with **setter injection**
* Use `@Lazy` annotation on one of the dependencies (for Java config)

Example with setter injection:

```xml
<bean id="a1" class="com.nit.sbeans.A">
    <property name="b" ref="b1"/>
</bean>
<bean id="b1" class="com.nit.sbeans.B">
    <property name="a" ref="a1"/>
</bean>
```

---

### 📚 Summary

This small project is useful to **understand limitations** of constructor injection and why setter injection can sometimes be necessary in Spring for resolving circular references.
