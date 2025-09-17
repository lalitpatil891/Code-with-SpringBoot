**Cyclic Dependency Injection**

---

**What is Cyclic Dependency?**
When two or more Spring beans depend on each other directly or indirectly, it creates a cycle.
For example:

* Bean A depends on Bean B
* Bean B depends on Bean A

This is called **cyclic dependency** or **circular dependency**.

---

**Why is it a Problem?**

* With **constructor injection**, cyclic dependency cannot be resolved.
* The IoC container tries to create Bean A, but needs Bean B.
* To create Bean B, it again needs Bean A.
* This creates a deadlock, and the container throws a `BeanCreationException`.

---

**How to Solve It?**

* Use **setter injection** instead of constructor injection.
* Spring first creates empty bean instances, then sets their dependencies through setter methods.
* This avoids the deadlock and allows cyclic dependencies.

---

**In Real Projects**

* Cyclic dependencies are generally avoided as they make design hard to maintain.
* If really needed, combining setter injection in one bean and constructor injection in another can support cyclic dependency in Spring.

---

**Important Points**
\=> Constructor injection does **not** support cyclic dependency because it needs fully constructed dependent objects at creation time.
\=> Setter injection **supports** cyclic dependency because dependencies are set after object creation.
\=> IoC container in Spring is AutoCloseable, so it can be used safely in try-with-resources to auto-close.

---

**Summary**
Cyclic dependency is when beans depend on each other, leading to potential issues.
Constructor injection cannot handle it; setter injection can.
But the best practice is to design applications to avoid cyclic dependencies.
