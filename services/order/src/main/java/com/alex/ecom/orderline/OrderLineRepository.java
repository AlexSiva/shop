package com.alex.ecom.orderline;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
}
