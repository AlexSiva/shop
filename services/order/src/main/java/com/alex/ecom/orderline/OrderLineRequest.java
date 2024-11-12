package com.alex.ecom.orderline;

public record OrderLineRequest(
        Integer id,
        Integer orderId,
        Integer productId
) {
}
