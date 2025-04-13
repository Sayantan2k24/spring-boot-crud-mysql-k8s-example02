package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }
    
    @GetMapping("/products/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        return service.searchByName(keyword);
    }

    @GetMapping("/products/searchByCategoryAndPrice")
    public List<Product> searchByCategoryAndPrice(@RequestParam String category, 
                                                @RequestParam double minPrice, 
                                                @RequestParam double maxPrice) {
        return service.searchByCategoryAndPrice(category, minPrice, maxPrice);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }


    @GetMapping("/products/advanced-search")
    public ResponseEntity<?> advancedSearch(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {
        try {
            // Validate price range if both are provided
            if (minPrice != null && maxPrice != null && minPrice > maxPrice) {
                return ResponseEntity.badRequest().body("Invalid price range: minPrice cannot be greater than maxPrice");
            }

            // If both category and price range are missing, return a bad request
            if (category == null && (minPrice == null && maxPrice == null)) {
                return ResponseEntity.badRequest().body("Missing required parameters: either category or price range must be provided");
            }

            // Perform the search operation
            List<Product> results = service.searchByCategoryAndPrice(category, minPrice, maxPrice);

            // If no products are found, return a 404 Not Found response
            if (results.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No products found matching criteria");
            }

            // Return the search results with 200 OK
            return ResponseEntity.ok(results);
        } catch (Exception e) {
            // Return a 500 Internal Server Error in case of unexpected errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

}
