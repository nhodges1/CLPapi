package clp.spring.api.Service;

import clp.spring.api.Model.Product;
import clp.spring.api.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    // Task1, Create Product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Task2, Retrieve all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Task3, Retrieve product by id
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Task4, List products by price in asc order
    public List<Product> getAllProductsSortedByPrice() {
        return productRepository.findAllByOrderByPriceAsc();
    }
}
