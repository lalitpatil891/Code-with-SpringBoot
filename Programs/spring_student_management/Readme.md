# 🌱 Spring Student Bean Demo

This is a simple Java project demonstrating **Spring Framework concepts** like:
- Dependency Injection (DI)
- Bean lifecycle methods
- Collection injection
- Injecting inner beans

The project uses an example of a `Student` who has:
- A name
- Roll number
- List of subjects
- An `Address` bean

---

## 📦 **Project Structure**

```plaintext
src/
├── com/example/beans/Student.java        # Student bean
├── com/example/beans/Address.java        # Address bean
├── com/example/cfgs/applicationContext.xml # Spring XML config
└── com/example/test/TestStudent.java     # Main class to run
````

---

## ✏ **Explanation (in simple words)**

✅ **Spring beans:**
In Spring, a *bean* is simply a Java object created and managed by Spring container.

✅ **Dependency Injection (DI):**
Instead of `Student` creating its own `Address` or `List<String>` inside the class,
we ask Spring to create them and **inject** them into the `Student` bean.
This makes the code clean, testable and flexible.

✅ **Bean lifecycle:**
We use `init-method` and `destroy-method` so Spring can call custom methods when:

* the bean is created (initialized)
* the bean is destroyed (context closed)

---

## 🧩 **How it works – Step by step**

1️⃣ Spring container reads `applicationContext.xml`
2️⃣ Creates `Address` bean with city = "Pune"
3️⃣ Creates `Student` bean, injects:

* name = "Lalit"
* rollNo = 101
* subjects list = \["Math", "Science", "English"]
* address = reference to Address bean
  4️⃣ Calls `init()` method of `Student`
  5️⃣ Main class (`TestStudent.java`) loads context and calls:

```java
student.showDetails();
```

6️⃣ At shutdown, Spring calls `destroy()` method.

---

## 📊 **Visual Flow (Text Diagram)**

```plaintext
applicationContext.xml
    |
    |--> <bean id="addr" class="Address"> (city=Pune)
    |
    |--> <bean id="stud" class="Student">
          - name: Lalit
          - rollNo: 101
          - subjects: [Math, Science, English]
          - address: ref="addr"
          - init-method="init"
          - destroy-method="destroy"

            |
            v

+---------------------------------------------+
| Spring IoC Container                        |
+---------------------------------------------+
| Creates Address bean                        |
| Creates Student bean                        |
| Injects dependencies into Student           |
| Calls Student.init()                        |
+---------------------------------------------+

            |
            v

+---------------------------------------------+
| TestStudent.java                            |
+---------------------------------------------+
| Loads Spring context                        |
| Gets Student bean                           |
| Calls student.showDetails()                 |
+---------------------------------------------+

            |
            v

+---------------------------------------------+
| Console output                              |
+---------------------------------------------+
| Student object created!                     |
| Student bean initialized!                   |
| ---- Student Details ----                    |
| Name: Lalit                                 |
| Roll No: 101                                |
| Subjects: [Math, Science, English]          |
| City: Pune                                  |
| Student bean destroyed!                     |
+---------------------------------------------+
```

---

## ⚙️ **Technologies Used**

* Java
* Spring Framework (core, beans, context)
* XML-based configuration

---

## ▶ **How to run**

1️⃣ Clone/download the project
2️⃣ Make sure you have Java & Spring libraries
3️⃣ Run `TestStudent.java`

Output:

```plaintext
Student object created!
Student bean initialized!
---- Student Details ----
Name: Lalit
Roll No: 101
Subjects: [Math, Science, English]
City: Pune
Student bean destroyed!
```

---

## 🧠 **What you learn from this project**

✅ What is a Spring bean
✅ Setter injection
✅ Inner bean injection
✅ Collection injection
✅ Bean lifecycle (`init-method`, `destroy-method`)
✅ How Spring container manages objects and dependencies

---

## ✨ **Why this is useful**

* Code becomes clean and modular
* Easy to replace or change beans without touching the Java code
* Shows power of Inversion of Control (IoC) and Dependency Injection (DI)

---

> 🌿 *This project is a perfect starting point to learn Spring beans, DI and XML configuration.*
> Happy coding! 🚀
