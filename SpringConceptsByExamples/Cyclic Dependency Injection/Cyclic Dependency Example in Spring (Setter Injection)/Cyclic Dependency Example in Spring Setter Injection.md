**Cyclic Dependency Example in Spring (Setter Injection)**
---
**Project Overview**
This project shows how Spring can handle cyclic dependency when two beans (A and B) depend on each other using setter injection instead of constructor injection.
---

**Project Structure**

src/
├── com/nit/sbeans/
│   ├── A.java
│   └── B.java
├── com/nit/main/
│   └── CyclicInjectionTest.java
└── com/nit/config/
└── ApplicationContext.xml

---

**Main Classes**

**A.java**

```
package com.nit.sbeans;

public class A {
    private B b;

    public void setB(B b) {
        this.b = b;
        System.out.println("A:: setB() method called");
    }

    public String toString() {
        return "From A";
    }
}
```

**B.java**

```
package com.nit.sbeans;

public class B {
    private A a;

    public void setA(A a) {
        this.a = a;
        System.out.println("B:: setA() method called");
    }

    public String toString() {
        return "From B";
    }
}
```

**CyclicInjectionTest.java**

```
package com.nit.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.nit.sbeans.A;
import com.nit.sbeans.B;

public class CyclicInjectionTest {
    public static void main(String[] args) {
        try (FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/com/nit/config/ApplicationContext.xml")) {
            A a = (A) ctx.getBean("a1");
            System.out.println("a= " + a);
            System.out.println("=====================");
            B b = (B) ctx.getBean("b1");
            System.out.println("b= " + b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

**Spring Configuration**

**ApplicationContext.xml**

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd">

  <bean id="a1" class="com.nit.sbeans.A">
    <property name="b" ref="b1"/>
  </bean>

  <bean id="b1" class="com.nit.sbeans.B">
    <property name="a" ref="a1"/>
  </bean>
</beans>
```

---

**What Happens**
When using setter injection, Spring can successfully create both beans even though they depend on each other.
The IoC container creates the bean objects first and then sets their dependencies.

---

**Cyclic Dependency Injection**

\=============================

\=> If two Spring beans depend on each other, this is cyclic or circular dependency.
\=> Setter injection supports cyclic dependency because Spring can first create bean objects and then inject dependencies.
\=> Constructor injection does not support cyclic dependency because it requires fully constructed dependent objects at creation time.

---

**Why Setter Injection Works**
Spring first creates empty bean instances, then calls setter methods to inject dependencies, so it avoids deadlock.

---

**In Real Projects**
\=> Generally, cyclic dependency is avoided.
\=> If needed, setter injection can handle it safely.
\=> We can use try-with-resources since the IoC container is AutoCloseable, so it will be closed automatically at the end of the try block.

---

**Purpose**
This project helps understand how setter injection can handle cyclic dependencies in Spring and why it’s sometimes necessary.
