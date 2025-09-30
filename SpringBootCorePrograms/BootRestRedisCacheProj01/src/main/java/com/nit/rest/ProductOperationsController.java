package com.nit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Product;
import com.nit.service.IProductMgmtService;

/**
 * REST Controller for Product operations.
 * Base path: /product-api
 * Uses ResponseEntity for proper HTTP status codes.
 */
@RestController  // Enables REST responses (JSON by default)
@RequestMapping("/product-api")  // Base URL path
@CrossOrigin(origins = "*")  // Optional: Allows CORS for testing
public class ProductOperationsController {

    @Autowired
    private IProductMgmtService prodService;  // Service injection

    /**
     * POST /product-api/save - Adds a new Product.
     */
    @PostMapping("/save")
    public ResponseEntity<String> saveProduct(@RequestBody Product prod) {  // JSON body to Product
        Product savedProduct = prodService.addProduct(prod);  // Calls service (caches result)
        return new ResponseEntity<>(savedProduct.toString() + " is saved", HttpStatus.CREATED);  // 201 Created
    }

    /**
     * GET /product-api/find/{pid} - Finds Product by ID.
     */
    @GetMapping("/find/{pid}")
    public ResponseEntity<Product> findProductById(@PathVariable int pid) {  // Path variable
        Product prod = prodService.findProductById(pid);  // Calls service (from cache if available)
        return new ResponseEntity<>(prod, HttpStatus.OK);  // 200 OK
    }

    /**
     * GET /product-api/report - Shows all Products.
     */
    @GetMapping("/report")
    public ResponseEntity<List<Product>> showAllProducts() {
        List<Product> list = prodService.showAllProducts();  // Calls service (from cache if available)
        return new ResponseEntity<>(list, HttpStatus.OK);  // 200 OK
    }

    /**
     * DELETE /product-api/delete/{pid} - Deletes Product by ID.
     */
    @DeleteMapping("/delete/{pid}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer pid) {  // Path variable (Integer for null safety)
        String msg = prodService.deleteProduct(pid);  // Calls service (evicts from cache)
        return new ResponseEntity<>(msg, HttpStatus.OK);  // 200 OK
    }
}