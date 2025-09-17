# 📘 Spring Data JPA – Repository Interfaces Hierarchy (Spring Boot 3.x)

### 🔹 1. Base Concept

* **Repository** is a **marker interface** (no methods).
* Provides abstraction for data access logic.
* IOC container (Spring) generates **in-memory proxy classes** at runtime implementing our repository.
* Developers create **custom repository interfaces** extending these base interfaces.

---

### 🔹 2. Main Repository Interfaces

1. **`Repository<T, ID>`**

   * Marker interface (no methods).
   * Super interface for all repositories.

2. **`CrudRepository<T, ID>`**

   * Extends `Repository`.
   * Provides basic **CRUD operations**:

     * `save()`
     * `findById()`
     * `findAll()`
     * `delete()`

3. **`PagingAndSortingRepository<T, ID>`**

   * Extends `Repository`.
   * Adds **pagination & sorting** capabilities:

     * `findAll(Pageable pageable)`
     * `findAll(Sort sort)`

4. **`ListCrudRepository<T, ID>`**

   * Extends `CrudRepository`.
   * Returns results as **List** instead of `Iterable`.

5. **`ListPagingAndSortingRepository<T, ID>`**

   * Extends `PagingAndSortingRepository`.
   * Returns results as **List** with pagination & sorting.

---

### 🔹 3. Specialized Repositories

1. **`JpaRepository<T, ID>`**

   * Extends `ListCrudRepository` + `ListPagingAndSortingRepository`.
   * Designed for **SQL databases** (JPA/Hibernate).
   * Adds more JPA-specific methods:

     * `flush()`
     * `saveAndFlush()`
     * `deleteInBatch()`
     * `getOne()`

2. **`MongoRepository<T, ID>`**

   * Designed for **NoSQL MongoDB**.
   * Adds MongoDB-specific methods.

3. **`CassandraRepository<T, ID>`**

   * Designed for **NoSQL Cassandra DB**.
   * Optimized for column-family storage.

---

### 🔹 4. Flow of Extension

```
Repository
   ├── CrudRepository → ListCrudRepository
   │        └── JpaRepository (SQL DB)
   │
   └── PagingAndSortingRepository → ListPagingAndSortingRepository
             ├── MongoRepository (NoSQL DB)
             └── CassandraRepository (NoSQL DB)
```

---

### 🔹 5. Key Points

✅ Always extend **JpaRepository** for SQL (most common in Spring Boot apps).
✅ Use **MongoRepository** or **CassandraRepository** for NoSQL databases.
✅ Spring automatically creates proxy classes for these interfaces at runtime → no need to write implementation.
✅ In modern Spring Boot (3.x), **List-returning repositories** are preferred (`ListCrudRepository`, `ListPagingAndSortingRepository`).
