# 📘 JPA Annotations in Spring Boot 3.x

### 🔹 1. Minimum Annotations for Entity Classes

* **Mandatory:**

  * `@Entity` → Marks a Java class as a JPA entity.
  * `@Id` → Marks a field as the **Primary Key**.
* **Optional:**

  * `@Column` → Maps a field to a specific database column.
  * `@Table` → Maps entity class to a specific database table.

---

### 🔹 2. Annotations Explanation

1. **`@Entity`**

   * Declares the class as an entity.
   * Each instance = one row in the database.

2. **`@Id`**

   * Identifies the **primary key** property.
   * ORM (Hibernate/JPA) uses this property to:

     * Sync entity objects with DB records.
     * Identify/update/delete records.
   * Usually mapped to **PK column of DB table**.

3. **`@Column`**

   * Maps an entity field to a database column.
   * Optional if property name = column name.

4. **`@Table`**

   * Maps entity class to a database table.
   * Optional if class name = table name.

---

### 🔹 3. Important Notes

* ORM always requires a **Primary Key** column (`@Id` must be present).
* If `@Table` / `@Column` are not given:

  * Entity class name = Table name.
  * Field/property names = Column names.
* In Spring Boot JPA, when generating new tables:

  * `@Id` property automatically becomes **Primary Key** column.

---

### 🔹 4. Example – Entity Class

```java
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    private Integer id;

    @Column(name = "doctor_name")
    private String name;

    @Column
    private String specialization;
}
```

---

# ⚡ Quick Revision – JPA Annotations

* `@Entity` → Marks class as entity.
* `@Id` → Primary key property.
* `@Column` → Map field → DB column (optional if names match).
* `@Table` → Map class → DB table (optional if names match).
* PK (`@Id`) **must exist** → ORM uses it to identify objects.
