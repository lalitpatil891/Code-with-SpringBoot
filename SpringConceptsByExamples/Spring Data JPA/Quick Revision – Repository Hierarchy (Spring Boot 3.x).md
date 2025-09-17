# ⚡ Quick Revision – Repository Hierarchy (Spring Boot 3.x)

### 🌟 Base

* **Repository** → Marker interface (no methods).

---

### 🔹 Core Repositories

* **CrudRepository** → Basic CRUD (`save, findById, findAll, delete`).
* **PagingAndSortingRepository** → Adds `findAll(Pageable)` & `findAll(Sort)`.
* **ListCrudRepository** → Same as CrudRepo but returns `List`.
* **ListPagingAndSortingRepository** → Same as Paging & Sorting but returns `List`.

---

### 🔹 Specialized

* **JpaRepository (SQL DB)** → Extends ListCrud + ListPagingAndSorting + JPA methods (`flush, saveAndFlush, deleteInBatch`).
* **MongoRepository (NoSQL – MongoDB)**.
* **CassandraRepository (NoSQL – Cassandra DB)**.

---

### 🔹 Extension Flow

```
Repository
   ├── CrudRepository → ListCrudRepository → JpaRepository (SQL DB)
   └── PagingAndSortingRepository → ListPagingAndSortingRepository
            ├── MongoRepository (NoSQL DB)
            └── CassandraRepository (NoSQL DB)
```

---

✅ Use **JpaRepository** for SQL DB (most common).
✅ Use **MongoRepository / CassandraRepository** for NoSQL.
✅ Spring generates proxy implementation automatically.

s
