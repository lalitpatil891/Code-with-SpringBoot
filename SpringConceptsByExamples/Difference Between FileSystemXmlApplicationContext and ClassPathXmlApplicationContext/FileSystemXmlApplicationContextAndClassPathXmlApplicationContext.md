**Difference Between FileSystemXmlApplicationContext and ClassPathXmlApplicationContext**

---

**FileSystemXmlApplicationContext**

* Loads the Spring bean configuration XML file from the file system.
* Can use:

  * **Relative path** (from the current working directory)
  * **Absolute path** (from the root of the file system)

Example using **relative path**:

```
FileSystemXmlApplicationContext ctx =
    new FileSystemXmlApplicationContext("src/com/nt/cfgs/applicationContext.xml");
```

Example using **absolute path**:

```
FileSystemXmlApplicationContext ctx =
    new FileSystemXmlApplicationContext("E:\\Workspaces\\Spring\\MyProject\\src\\com\\nt\\cfgs\\applicationContext.xml");
```

**Use case:**

* When your XML configuration is *outside* the project classpath.
* Helpful during development or testing if config files are stored separately.

---

**ClassPathXmlApplicationContext**

* Loads the Spring bean configuration XML file from the **classpath**.
* Searches in folders or jar files that are added to the **CLASSPATH / BUILDPATH** of the project.

Example:

```
ClassPathXmlApplicationContext ctx =
    new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
```

**In Eclipse or any IDE:**

* By default, the `src` folder is included in the build path.
* So `com/nt/cfgs/applicationContext.xml` inside `src` is already in the classpath.
* If you make own package then fallow this technique->
First add com/example/config folder or package to CLASSPATH/BUILDPATH of the eclipse project [right click on com/exaple/config folder/package -->buildpath -->Use as a source folder]

* Best practice: keep Spring config files in `src` or in a folder/package added to the classpath.

---

**Important Points:**
\=> FileSystemXmlApplicationContext can locate files anywhere, inside or outside the project, using file system paths.
\=> ClassPathXmlApplicationContext only loads files from the classpath (e.g., inside `src`, `resources`, or jars).
\=> In real-world Spring projects, **ClassPathXmlApplicationContext** is preferred because:

* It keeps config files portable and avoids hardcoded absolute paths.
* It works seamlessly in production when packaged as a jar/war.
* Supports classloader mechanisms.

---

**Tip:**
If you want to use `ClassPathXmlApplicationContext` and the config is not in `src`,

* Right-click the folder (e.g., `com/nt/cfgs`) → Build Path → Use as Source Folder.
  This will add it to the classpath.

---

**Summary:**

* **FileSystemXmlApplicationContext:** flexible, loads from any location, uses file system paths.
* **ClassPathXmlApplicationContext:** loads only from classpath, better for real apps and deployment.

---
