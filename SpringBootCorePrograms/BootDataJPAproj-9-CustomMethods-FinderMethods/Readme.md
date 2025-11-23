# 📘 **README – Spring Data JPA Custom Finder Methods**

This project demonstrates **Spring Data JPA derived/custom finder methods** using simple queries generated automatically from method names. It includes a `JobSeeker` entity, a `JpaRepository` interface with multiple custom methods, and a `CommandLineRunner` that tests them.

---

# 🚀 **Project Overview**

Spring Data JPA allows writing queries **without using JPQL or SQL**.  
It creates queries automatically from the method names based on naming conventions.

Example:

```java
List<JobSeeker> findByJsaddrsEquals(String addrs);
```

Spring converts this method name into:

```sql
SELECT * FROM job_seeker WHERE jsaddrs = :addrs;
```

No query writing required — everything is handled by *method naming*.

This project showcases various types of finder methods such as:

- Equality checks  
- Range queries  
- LIKE operations  
- Pattern matching  
- Sorting  
- NOT IN / NOT LIKE  
- Combination of conditions with AND / OR  

---

# 🏗 **Project Structure**

```
src/main/java/com/nit/
│
├── entity/
│   └── JobSeeker.java
│
├── repository/
│   └── IJobSeekerRepository.java
│
├── runners/
│   └── CustomFinderMethodsTestRunner.java
│
└── BootDataJpAproj9CustomMethodsFinderMethods.java
```

---

# 🧪 **How the Runner Works**

`CustomFinderMethodsTestRunner` implements `CommandLineRunner`, which means  
**all code inside run() executes automatically when the Spring Boot app starts**.

It tests multiple repository finder methods:

### ✔ Search by Address  
```java
repo.getByJsaddrs("Hyderabad");
```

### ✔ Salary Range  
```java
repo.findByExpectedSalaryBetween(30000, 40000);
```

### ✔ Pattern Matching (LIKE, CONTAINING)  
```java
repo.findByJsnameContaining("aja");
```

### ✔ Sorting  
```java
repo.findByJsaddrsInOrderByJsnameDesc(List.of("Pune", "Nagpur"));
```

### ✔ Advanced Logical Operators  
```java
repo.findByJsaddrsNotInOrQlfyNotLike(List.of("Pune", "Mumbai"), "B");
```

Each block is wrapped inside try–catch to handle exceptions safely.

---

# 📚 **Repository Finder Methods Explained**

Here are the types of derived query methods used:

### 🔹 1. **Equality Methods**
```java
findByJsaddrsEquals(String addrs)
readByJsaddrsIs(String addrs)
getByJsaddrs(String addrs)
```
All three perform *same* operation — match exact address.

---

### 🔹 2. **Range Queries**
```java
findByExpectedSalaryBetween(double start, double end)
findByExpectedSalaryGreaterThanEqualAndExpectedSalaryLessThanEqual(start, end)
```

---

### 🔹 3. **Sorting**
```java
findByJsaddrsInOrderByJsnameDesc(List<String> cities)
```

---

### 🔹 4. **Pattern Matching (LIKE)**
```java
findByJsnameStartingWith('P')
findByJsnameEndingWith('a')
findByJsnameContaining("nit")
findByJsnameEqualsIgnoreCase("KAJAL")
```

---

### 🔹 5. **Combined Conditions**
```java
findByJsaddrsLikeAndQlfyIn("Pune", List.of("B.E", "B.Tech"))
```

---

### 🔹 6. **Negative Conditions**
```java
findByJsaddrsNotInOrQlfyNotLike(List<String> list, String pattern)
```

Spring Data JPA understands these keywords:

| Keyword | Meaning |
|--------|---------|
| `Equals`, `Is`, `Get` | exact match |
| `Between` | start to end |
| `GreaterThanEqual` | >= |
| `LessThanEqual` | <= |
| `In`, `NotIn` | list-based search |
| `Like`, `NotLike` | wildcard-based |
| `StartingWith` | prefix search |
| `EndingWith` | suffix search |
| `Containing` | substring search |
| `OrderBy` | sorting |
| `IgnoreCase` | case insensitive |

---

# 🛠 **How to Run the Project**

### 1️⃣ Start your MySQL or H2 database  
Ensure your DB connection is correct in `application.properties`.

### 2️⃣ Run the Spring Boot Application  
Using IDE:

```
Right Click → Run As → Spring Boot App
```

Using terminal:

```
mvn spring-boot:run
```

### 3️⃣ Output will appear in console  
All finder methods will print JobSeeker data fetched from DB.

---
