## **`@Entity`**

* `@Entity` is a JPA (Java Persistence API) annotation.
* It tells Spring Boot (and Hibernate) that this Java class represents a **table** in the database.
* Each object of this class corresponds to a **row** in that table.
* Without `@Entity`, Hibernate will ignore this class and will not create a table for it.

---

## **Java Class**

```java
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    private int prodId;
    private String prodName;
    private int price;

    // Getters, setters, constructors...
}
```
---

## **What Happens in Database (H2 Example)**

When you run your Spring Boot app, Hibernate will create a table like this:

**`PRODUCT` table**

| prodId (PK) | prodName      | price |
| ----------- | ------------- | ----- |
| 101         | Tea Powder    | 120   |
| 102         | Coffee Powder | 150   |
| 103         | Sugar         | 50    |

---

### **How it Works**

* **`@Entity`** → Tells Hibernate to create a table named `Product` (or `PRODUCT` in uppercase).
* **`@Id`** → Tells Hibernate that `prodId` is the **Primary Key** column — each row must have a unique `prodId`.
