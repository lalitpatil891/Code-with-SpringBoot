Here’s a **README.md** file you can use for your project, written clearly and professionally in Markdown:

---

## 📦 Spring Cyclic Dependency Injection Example (Setter Injection)

This project demonstrates how **Spring Framework** handles **cyclic (circular) dependency injection** using **setter injection**.

> 📌 **Note:** Constructor injection cannot resolve cyclic dependencies because both beans depend on each other at creation time. Setter injection works because the IOC container can first create the beans, then call their setters to wire them together.

---

### ✅ Project Structure

```
IOCProj03-cyclcDI-SetterInjection/
├── src/
│   ├── com.nt.beans/
│   │   ├── A.java
│   │   └── B.java
│   ├── com.nt.cfgs/
│   │   └── applicationContext.xml
│   └── com.nt.test/
│       └── CyclicInjectionTest.java
```

---

### 📄 Explanation

* **Class `A`**

  * Has a dependency on `B`
  * Contains:

    * Default constructor
    * Setter method `setB()`

* **Class `B`**

  * Has a dependency on `A`
  * Contains:

    * Default constructor
    * Setter method `setA()`

* **applicationContext.xml**

  * Defines two Spring beans: `a1` (of class `A`) and `b1` (of class `B`)
  * Uses setter injection to assign each other:

    ```xml
    <bean id="a1" class="com.nt.beans.A">
        <property name="b" ref="b1"/>
    </bean>

    <bean id="b1" class="com.nt.beans.B">
        <property name="a" ref="a1"/>
    </bean>
    ```

* **CyclicInjectionTest.java**

  * Loads Spring container from `applicationContext.xml`
  * Retrieves and tests the beans

---

### 🧪 How Cyclic Dependency is Resolved

* Spring first **creates empty instances** of beans `A` and `B` (using default constructors).
* Then Spring calls setter methods:

  * `a1.setB(b1)`
  * `b1.setA(a1)`
* This resolves the circular dependency.

> ⚠ Constructor injection can't do this because both objects would need each other fully constructed at the same time.

---

### 🛠 How to Disable Block Comment Formatting in Eclipse

If multiline comments disturb code formatting:

1. Go to `Window` → `Preferences`
2. Search: `formatter` → `Java` → `Code Style` → `Formatter`
3. Create or edit a profile
4. Go to `Comments`
5. Uncheck **Enable block comment formatting**

---

### ✅ Output

You will see console output showing:

* Default constructors called
* Setter methods called
* Final output showing the `toString()` of beans

---

### 📝 Commit messages suggestions

* `feat: add cyclic dependency example with setter injection`
* `docs: add README explaining cyclic dependency handling`
* `config: add Spring XML config for cyclic dependencies`
