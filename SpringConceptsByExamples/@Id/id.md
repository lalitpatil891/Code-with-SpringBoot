## **`@Id`**

* `@Id` marks the **primary key** for the entity (table).
* Every table must have a unique identifier for each row — that’s the primary key.
* In this example, `prodId` is the primary key for the `Product` table.

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
