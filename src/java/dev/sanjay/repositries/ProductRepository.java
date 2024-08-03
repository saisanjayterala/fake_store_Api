package dev.sanjay.repositories;

import dev.sanjay.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
        @Override
    Optional<Product> finalById(Long id);

    @Override
    Product save(Product product);
}
