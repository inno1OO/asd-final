package edu.miu.asd.demo.repository;

import edu.miu.asd.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
