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
