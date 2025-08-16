@RequestMapping

Definition:
@RequestMapping maps an HTTP request (URL) to a specific method or class in your controller.

Simple Rules:

Can be used on class (for common base URL) or on method (for specific endpoint).

Supports all HTTP methods (GET, POST, PUT, DELETE).

You can specify path, HTTP method, headers, etc.

Shortcuts exist like @GetMapping, @PostMapping, etc.

Example:

@RestController
@RequestMapping("/api") // Base URL
public class MyController {

    @RequestMapping("/hello") // Final URL: /api/hello
    public String sayHello() {
        return "Hello from API";
    }
}
