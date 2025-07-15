**Using IoC Container in Spring**

---

**What is IoC (Inversion of Control)?**
Inversion of Control means the control of creating and managing objects is given to the Spring framework, not written manually in our code.
Spring uses IoC containers to manage these objects, called beans.

---

**Why IoC Container?**

* Automatically manages bean creation and lifecycle
* Handles dependency injection (DI)
* Helps decouple code, making it easier to test and maintain

---

**Types of IoC Containers in Spring**

* BeanFactory: Basic container; lazy initialization; fewer features
* ApplicationContext: Advanced container; eager initialization; supports:

  * Event handling
  * Internationalization
  * Bean post-processors and more

In most real projects, ApplicationContext is preferred.

---

**Different Ways to Create ApplicationContext**

1. ClassPathXmlApplicationContext
   Loads configuration XML file from classpath.

   ```
   ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nit/config/ApplicationContext.xml");
   ```

2. FileSystemXmlApplicationContext
   Loads XML from absolute or relative filesystem path.

   ```
   ApplicationContext ctx = new FileSystemXmlApplicationContext("src/com/nit/config/ApplicationContext.xml");
   ```

3. AnnotationConfigApplicationContext
   Used for Java-based configuration using annotations like @Configuration.

   ```
   ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfigClass.class);
   ```

---

**AutoCloseable and try-with-resources**

* ApplicationContext implementations like FileSystemXmlApplicationContext are AutoCloseable.
* Using them inside try-with-resources block automatically closes the container:

```
try (FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/com/nit/config/ApplicationContext.xml")) {
    // use ctx
}
// ctx is closed automatically here
```

---

**How to Get Beans from IoC Container**

Different ways to fetch beans after context is created:

* By id/name with type casting

```
A a = (A) ctx.getBean("a1");
```

* By id/name with generic

```
A a = ctx.getBean("a1", A.class);
```

* By type only

```
A a = ctx.getBean(A.class);
```

---

**Notes about getBean()**

* Returns existing singleton bean object (by default scope).
* Generic getBean(id, class) is type-safe and avoids ClassCastException.
* If bean id is wrong, Spring throws NoSuchBeanDefinitionException.

---

**Commonly Used ApplicationContext Implementations**

* ClassPathXmlApplicationContext: loads from classpath
* FileSystemXmlApplicationContext: loads from filesystem
* AnnotationConfigApplicationContext: for Java config
* WebApplicationContext: for web apps

---

**Advantages of ApplicationContext over BeanFactory**

* Supports internationalization (i18n)
* Supports event propagation (publish/subscribe)
* Supports declarative mechanisms like BeanPostProcessor and BeanFactoryPostProcessor
* Creates singleton beans at container startup (eager initialization), making errors visible earlier

---

**When to Use Which**

* For simple projects or learning: ClassPathXmlApplicationContext
* For file-system-based configs: FileSystemXmlApplicationContext
* For Java config with annotations: AnnotationConfigApplicationContext
* Avoid BeanFactory unless working on low-level resource-constrained apps

---

**Important Points to Remember**
\=> IoC container manages object creation, configuration, and wiring.
\=> ApplicationContext is most commonly used in real projects.
\=> Use type-safe getBean methods to avoid casting issues.
\=> Use try-with-resources to auto-close the container.
\=> Default bean scope is singleton; multiple calls to getBean() return same object.
\=> ApplicationContext creates singleton beans eagerly; BeanFactory creates lazily.

---

**Summary**

* Spring IoC Container helps manage beans and dependencies.
* ApplicationContext is powerful and feature-rich.
* Helps create maintainable, decoupled, and testable applications.
