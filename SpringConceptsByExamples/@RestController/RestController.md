1. @RestController

Definition:
@RestController is a Spring Boot annotation used to mark a class as a controller where every method returns data (like JSON or XML) instead of a view (HTML page).
It’s basically @Controller + @ResponseBody combined.

Simple Rules:

Put it on top of a class.

All methods in the class will return data directly (no need to use @ResponseBody every time).

Mostly used in REST APIs.

Example:

@RestController
public class MyController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
