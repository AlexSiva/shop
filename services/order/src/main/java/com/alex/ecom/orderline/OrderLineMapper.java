package com.alex.ecom.orderline;

import com.alex.ecom.order.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.orderId())
                .productId(request.productId())
                .order(
                        Order.builder()
                                .id(request.orderId())
                                .build()
                )
                .build();
    }

//    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
//        return new OrderLineResponse(
//                orderLine.getId()
//        );
//    }
}
