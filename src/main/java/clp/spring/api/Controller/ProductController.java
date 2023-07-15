package clp.spring.api.Controller;

import clp.spring.api.Model.Product;
import clp.spring.api.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Task1, Create a product
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    // Task2, Retrieve all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Task3, Retrieve product by id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Task4, Retrieve products by price in asc order
    @GetMapping("/sorted")
    public ResponseEntity<List<Product>> getAllProductsSortedByPrice() {
        List<Product> products = productService.getAllProductsSortedByPrice();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Task5, Filter products by price range
    @GetMapping("/filter")
    public ResponseEntity<List<Product>> filterProductsByPriceRange(
            @RequestParam("minPrice") double minPrice,
            @RequestParam("maxPrice") double maxPrice
    ) {
        List<Product> filteredProducts = productService.filterProductsByPriceRange(minPrice, maxPrice);
        return new ResponseEntity<>(filteredProducts, HttpStatus.OK);
    }

    // Task6, Retrieve the count of all products
    @GetMapping("/count")
    public ResponseEntity<Long> getProductCount() {
        Long productCount = productService.getProductCount();
        return new ResponseEntity<>(productCount, HttpStatus.OK);
    }

    // Task7, Search products by name
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProductsByName(
            @RequestParam("name") String name
    ) {
        List<Product> searchResults = productService.searchProductsByName(name);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }

    // Task8, Update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody Product updatedProduct
    ) {
        Product product = productService.updateProduct(id, updatedProduct);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Task9, Delete a product by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean isDeleted = productService.deleteProduct(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
