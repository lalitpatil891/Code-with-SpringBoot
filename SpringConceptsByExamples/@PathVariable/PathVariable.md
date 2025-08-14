## **Definition**

`@PathVariable` is used to **extract values directly from the URL path** and assign them to method parameters in a controller.

---

## **Rules**

1. The `{variable}` in the URL **must match** the parameter name in the method (or use `@PathVariable("name")`).
2. Mostly used with `@GetMapping`, `@DeleteMapping`, `@PutMapping`.
3. Useful when you want to pass values as part of the URL, not as query parameters.
4. Can be used for **multiple values** in the same URL.
5. Works with **any data type** supported by Spring (int, String, etc.).

---

## **Example**

```java
@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable int id) {
        return "User ID: " + id;
    }

    @GetMapping("/user/{id}/post/{postId}")
    public String getUserPost(@PathVariable int id, @PathVariable int postId) {
        return "User ID: " + id + ", Post ID: " + postId;
    }
}
```

**Request:**

```
GET /user/10
```

**Output:**

```
User ID: 10
```

**Request:**

```
GET /user/10/post/5
```

**Output:**

```
User ID: 10, Post ID: 5
```
