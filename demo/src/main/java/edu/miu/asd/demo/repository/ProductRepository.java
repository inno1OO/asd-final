package edu.miu.asd.demo.repository;

import edu.miu.asd.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
