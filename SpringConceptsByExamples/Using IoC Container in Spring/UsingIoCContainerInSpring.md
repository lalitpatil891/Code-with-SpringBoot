**Using IoC Container in Spring**

---

**What is IoC (Inversion of Control)?**
Inversion of Control means giving control of object creation and wiring to the Spring framework.

Example without Spring:

```
A a = new A();
B b = new B(a);
```

With Spring, objects are created and injected automatically by the container.

---

**Why IoC Container?**

* Manages beans and their dependencies automatically
* Reduces manual new object creation
* Makes code loosely coupled and easier to test

---

**Types of IoC Containers in Spring**

* BeanFactory: Basic container
* ApplicationContext: Advanced container

Example:

```
BeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans.xml"));
ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
```

---

**Different Ways to Create ApplicationContext**

**1. ClassPathXmlApplicationContext**
Loads config from classpath.

```
ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nit/config/ApplicationContext.xml");
```

**2. FileSystemXmlApplicationContext**
Loads from filesystem path.

```
ApplicationContext ctx = new FileSystemXmlApplicationContext("src/com/nit/config/ApplicationContext.xml");
```

**3. AnnotationConfigApplicationContext**
Used for Java-based configuration.

```
@Configuration
public class AppConfig {
    @Bean
    public A a() { return new A(); }
}

ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
```

---

**AutoCloseable and try-with-resources**
Since some ApplicationContext implementations implement AutoCloseable, use:

```
try (FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/com/nit/config/ApplicationContext.xml")) {
    // use ctx
}
// ctx closed automatically
```

---

**How to Get Beans from IoC Container**

**By id with casting**

```
A a = (A) ctx.getBean("a1");
```

**By id with type**

```
A a = ctx.getBean("a1", A.class);
```

**By type only**

```
A a = ctx.getBean(A.class);
```

---

**Notes about getBean()**

* Returns bean instance managed by Spring.
* Type-safe methods with generics help avoid ClassCastException.
* Throws NoSuchBeanDefinitionException if id or type is wrong.

---

**Commonly Used ApplicationContext Implementations**

* ClassPathXmlApplicationContext
* FileSystemXmlApplicationContext
* AnnotationConfigApplicationContext
* WebApplicationContext

Example:

```
ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
```

---

**Advantages of ApplicationContext over BeanFactory**

* Supports bean post-processing
* Supports event publishing
* Supports i18n (messages)
* Eager initialization of singleton beans

Example:

```
ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
```

---

**When to Use Which**

* ClassPathXmlApplicationContext: config inside classpath
* FileSystemXmlApplicationContext: config outside classpath
* AnnotationConfigApplicationContext: Java @Configuration classes

---

**Important Points to Remember**
\=> IoC container manages creation, wiring, and lifecycle.
\=> Prefer ApplicationContext in most projects.
\=> Use generic getBean() to avoid casting.
\=> Default bean scope is singleton.
\=> try-with-resources auto-closes container.

---

**Summary**
Spring IoC container makes code simpler, testable, and decoupled by taking over bean management.
