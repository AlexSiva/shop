package com.alex.ecom.order;

import com.alex.ecom.customer.CustomerClient;
import com.alex.ecom.exception.BusinessException;
import com.alex.ecom.orderline.OrderLineRequest;
import com.alex.ecom.orderline.OrderLineService;
import com.alex.ecom.product.ProductClient;
import com.alex.ecom.product.PurchaseRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    public Integer createOrder(@Valid OrderRequest orderRequest) {
        var customer = this.customerClient.findCustomerById(orderRequest.customerId())
                .orElseThrow(()-> new BusinessException("impossible to create order"));
        this.productClient.purchaseProducts(orderRequest.products());
        var order = this.orderRepository.save(mapper.toOrder(orderRequest));
        for (PurchaseRequest req: orderRequest.products()) {
            orderLineService.saveOrderLine(new OrderLineRequest(null, order.getId(), req.productId()));
        }
        return null;
    };
}
