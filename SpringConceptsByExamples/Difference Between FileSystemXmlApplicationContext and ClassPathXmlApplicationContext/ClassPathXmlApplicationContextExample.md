## ✅ Example: `ClassPathXmlApplicationContext`

> Load Spring XML config from inside the classpath (`src/main/resources/beans.xml`)

### 📝 `MyBean.java`

```java
package com.example.demo;

public class MyBean {
    public void sayHello() {
        System.out.println("Hello from MyBean (ClassPathXmlApplicationContext)!");
    }
}
```

---

### 🏁 `App.java`

```java
package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("beans.xml");
        MyBean bean = context.getBean(MyBean.class);
        bean.sayHello();
    }
}
```

---

### 📦 `src/main/resources/beans.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myBean" class="com.example.demo.MyBean" />
</beans>
```
