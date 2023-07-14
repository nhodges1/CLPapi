package clp.spring.api.Repository;

import clp.spring.api.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Task4, List products by asc order
    List<Product> findAllByOrderByPriceAsc();

    // Task5, Filter products by price range
    List<Product> findByPriceBetween(double minPrice, double maxPrice);
}
