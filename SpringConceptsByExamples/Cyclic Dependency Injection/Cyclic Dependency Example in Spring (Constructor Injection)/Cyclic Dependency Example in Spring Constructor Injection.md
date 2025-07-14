**Project Overview**
This project shows what happens when two Spring beans (A and B) depend on each other through constructor injection, causing a cyclic dependency error at runtime.

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

    public A(B b) {
        this.b = b;
        System.out.println("B:: 1-param Constructor");
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

    public B(A a) {
        this.a = a;
        System.out.println("A:: 1-param constructor");
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
    <constructor-arg name="b" ref="b1"/>
  </bean>

  <bean id="b1" class="com.nit.sbeans.B">
    <constructor-arg name="a" ref="a1"/>
  </bean>
</beans>
```

---

**What Happens**
When running, Spring throws a BeanCreationException because it cannot resolve the circular dependency through constructor injection.

---

**Cyclic Dependency Injection**

\=============================

\=> If two Spring beans are dependent on each other, we say they are in cyclic or circular dependency.
\=> If A and B Spring beans are dependent on each other, it creates a cyclic dependency.
\=> Setter injection supports cyclic/circular dependency, whereas constructor injection does not.

---

**Why Constructor Injection Fails**
Constructor injection does not support cyclic dependency injection because the IoC container gets into a deadlock situation:

* While creating the target object, it needs the dependent object.
* But the dependent object also needs the target object.
  This results in an error during bean creation.

---

**In Real Projects**
\=> Generally, cyclic dependency injections are avoided.
\=> If needed, using setter injection in one bean and constructor injection in the other can support cyclic DI.
\=> Since any implementation of the IoC container is AutoCloseable, we can create it inside try-with-resources so it will automatically close at the end of the try block.

---

**Solution**
Use setter injection instead of constructor injection to break the cycle.

---

**Purpose**
This project helps understand Spring's limitation with constructor-based cyclic dependencies and shows why setter injection is sometimes necessary.
