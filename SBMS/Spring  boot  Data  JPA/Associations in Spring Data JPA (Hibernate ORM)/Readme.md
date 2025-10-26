# 🧩 Associations in Spring Data JPA (Hibernate ORM)

### Also Known As:

* **Relationships / Association Mapping / Multiplicity** in ORM
* Implemented in: **Spring Boot Data JPA / Hibernate**

---

## 📌 Why Keep Database Tables in Association?

Keeping multiple entities in a single table causes:

| Problem                | Description                           |
| ---------------------- | ------------------------------------- |
| **Data Redundancy**    | Duplicate data across records         |
| **Data Inconsistency** | Hard to manage or update related data |

### ❌ Problem Example (Single Table)

**Customer and Phone Details**

| cno | cname  | caddrs | mobileNo   | provider | type      |
| --- | ------ | ------ | ---------- | -------- | --------- |
| 101 | Raja   | Hyd    | 9999999999 | Airtel   | Residence |
| 101 | Raja   | Hyd    | 9999999888 | Vodafone | Office    |
| 102 | Mahesh | Vizag  | 9499999888 | Jio      | Office    |
| 102 | Mahesh | Vizag  | 9499999888 | Vodafone | Residence |

➡️ Data duplication and management difficulty.

---

## ✅ Solution 1 – Separate Tables (Not Recommended)

| Customer           | Phone_Details                   |
| ------------------ | ------------------------------- |
| cno, cname, caddrs | regNo, mobileNo, provider, type |

❌ No relation between tables → can’t access phone details from customer or vice-versa.

---

## ✅ Solution 2 – Relationship Using Foreign Key (Recommended)

**Customer (Parent Table)**

| cno (PK) | cname  | caddrs |
| -------- | ------ | ------ |
| 101      | Raja   | Hyd    |
| 102      | Mahesh | Vizag  |

**Phone_Details (Child Table)**

| regNo (PK) | mobileNo   | provider | type      | customer_no (FK) |
| ---------- | ---------- | -------- | --------- | ---------------- |
| 1          | 9999999999 | Airtel   | Residence | 101              |
| 2          | 9999999888 | Vodafone | Office    | 101              |
| 3          | 9499999888 | Jio      | Office    | 102              |
| 4          | 9499999888 | Vodafone | Residence | 102              |

---

## 🧠 UML Diagram: Customer ↔ PhoneNumber (One-to-Many)

```
+----------------+          +----------------------+
|   Customer     | 1     * |    PhoneNumber       |
+----------------+----------+----------------------+
| cno (PK)       |          | regNo (PK)           |
| cname          |          | mobileNo             |
| caddrs         |          | provider             |
|                |          | type                 |
|                |          | customer_no (FK) --> cno |
+----------------+          +----------------------+
```

✅ One Customer → Many Phone Numbers
✅ Foreign Key in `PhoneNumber` table

---

## 🧩 Types of Associations in JPA / Hibernate

| Type             | Example                                   |
| ---------------- | ----------------------------------------- |
| **One-to-One**   | Student ↔ RankInfo, Citizen ↔ Passport    |
| **One-to-Many**  | Customer → PhoneNumbers, Dept → Employees |
| **Many-to-One**  | Employee → Department, Student → College  |
| **Many-to-Many** | Student ↔ Course, Doctor ↔ Patient        |

---

## 🔄 Association Modes

| Mode                | Access Direction                           | Example                             |
| ------------------- | ------------------------------------------ | ----------------------------------- |
| **Uni-Directional** | One-way (Parent → Child OR Child → Parent) | Only one entity knows the other     |
| **Bi-Directional**  | Two-way (Parent ↔ Child)                   | Both entities can access each other |

> 💡 Best practice: Keep **Foreign Key (FK)** in **child table** for cleaner design.

---

## 🧬 Entity Class Associations

* **Reference Type (Non-Collection)** → `@OneToOne`, `@ManyToOne`
* **Collection Type (List/Set/Map)** → `@OneToMany`, `@ManyToMany`

---

## 🔗 Example: One-to-Many / Many-to-One (Bi-Directional)

### Database Tables

**Person (Parent)**

| PID (PK) | PNAME  | PADDRS |
| -------- | ------ | ------ |
| 1        | Raja   | Hyd    |
| 2        | Suresh | Vizag  |

**PhoneNumber (Child)**

| REGNO (PK) | PHONENO    | PROVIDER | TYPE     | PERSON_ID (FK) |
| ---------- | ---------- | -------- | -------- | -------------- |
| 1000       | 99999999   | Airtel   | Personal | 1              |
| 1001       | 88888888   | Jio      | Office   | 1              |
| 1002       | 7777777999 | Airtel   | Personal | 2              |
| 1003       | 66666666   | BSNL     | Office   | 2              |

---

### UML Diagram: Person ↔ PhoneNumber (Bi-Directional)

```
+-------------+            +------------------+
|   Person    | 1       * |   PhoneNumber    |
+-------------+------------+------------------+
| pid (PK)    |            | regNo (PK)       |
| pname       |            | phoneNo          |
| paddr       |            | provider         |
|             |            | type             |
|-------------|            | person_id (FK) → pid |
| phoneNumbers|<-----------+ person           |
+-------------+            +------------------+
```

---

### Java Implementation

```java
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    private String pname;
    private String paddr;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<PhoneNumber> phoneNumbers;
}
```

```java
@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regNo;
    private String provider;
    private String type;
    private String phoneNo;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
```

---

## ⚙️ Cascade Types in Associations

| Cascade Type | Effect                       |
| ------------ | ---------------------------- |
| `ALL`        | Apply all cascade operations |
| `PERSIST`    | Save parent → save child     |
| `REMOVE`     | Delete parent → delete child |
| `MERGE`      | Update parent → update child |
| `DETACH`     | Detach both from context     |
| `REFRESH`    | Refresh both from DB         |

> 🔥 **Recommended:** Use `CascadeType.ALL` for complete synchronization.

---

## ⚠️ Key Design Guidelines

| Recommendation                                               | Reason                                 |
| ------------------------------------------------------------ | -------------------------------------- |
| Avoid using **natural keys** (mobileNo, voterId, etc.) as PK | External values can change             |
| Use **surrogate keys** (auto-generated IDs)                  | Stable and system-generated            |
| Always keep **FK in child table**                            | Avoids redundancy and eases navigation |

---

## 🧱 Summary

| Concept                 | Description                            |
| ----------------------- | -------------------------------------- |
| **Association Mapping** | Defines relationships between entities |
| **Uni/Bi-directional**  | Defines direction of entity access     |
| **Cascade**             | Propagates persistence operations      |
| **FK Column**           | Connects parent and child tables       |
| **Surrogate Keys**      | Auto-generated, ideal for PKs          |

---

## 🧰 JPA Annotations Reference

| Annotation    | Usage                                     |
| ------------- | ----------------------------------------- |
| `@OneToOne`   | One-to-One mapping                        |
| `@OneToMany`  | One-to-Many mapping                       |
| `@ManyToOne`  | Many-to-One mapping                       |
| `@ManyToMany` | Many-to-Many mapping                      |
| `@JoinColumn` | Specifies FK column                       |
| `@JoinTable`  | Specifies intermediate join table for M–M |

---

## 🧭 Conclusion

* Use **associations** for normalized and relational data structure.
* Define relationships clearly using **JPA annotations**.
* Prefer **bi-directional mappings** with **FK in child tables**.
* Use **cascade operations** to simplify data persistence.

---