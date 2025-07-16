## 🌱 **Spring App Development using XML + Annotation Driven Configurations**

---

### ✅ **Different ways of developing Spring Apps**

* (a) Using **XML based configs** only
* (b) Using **Java Annotations** only
* (c) Using **Hybrid** approach (XML + Annotations)

---

### 🛠 **Using XML + Annotation driven configs (Hybrid approach)**

When we want to configure some beans in XML, and also use annotations (e.g., `@Component`, `@Service`, `@Repository` etc.),
Spring supports mixing both.

This approach helps:

* Keep configuration separate and clear
* Use powerful Spring annotations to reduce XML boilerplate
* Still configure special beans, 3rd-party classes, or advanced configs in XML

---

### ⚙ **How it works:**

1. Define your beans and enable annotation scanning in `applicationContext.xml`:

```xml
<context:component-scan base-package="com.nit" />
<context:annotation-config />
```

2. Annotate your classes:

```java
@Component("seasonFinder")
public class SeasonFinder {
    public String findSeason(int month) {
        if(month >=3 && month<=6)
            return "Summer";
        else if(month >=7 && month<=10)
            return "Rainy";
        else
            return "Winter Season";
    }
}
```

---

## ✅ **Example:**

### `applicationContext.xml`:

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
           http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="com.nit"/>
</beans>
```

---

### `MainApp.java`:

```java
package com.nit.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.nit.sbeans.SeasonFinder;

public class MainApp {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            SeasonFinder finder = ctx.getBean("seasonFinder", SeasonFinder.class);
            String result = finder.findSeason(4);
            System.out.println("Season is: " + result);
        }
    }
}
```

---

## 🖼 **Diagram / Notes**

!\[Spring App using xml+annotation]\(https://github.com/lalitpatil891/Code-with-SpringBoot/blob/main/SBMS/SpringCore/NTSPBMS718-%20Session11-Spring%20App%20development%20using%20xml%2Bannotation%20driven%20cfgs%20.png)

*(Make sure the image is placed in your project root or adjust the path.)*

---

### ✅ **Advantages:**

* Use power of annotations (`@Component`, `@Service`, etc.)
* Still configure special cases in XML
* Cleaner and more maintainable

---
