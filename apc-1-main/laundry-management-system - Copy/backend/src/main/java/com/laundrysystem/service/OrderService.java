
package com.laundrysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laundrysystem.model.Order;
import com.laundrysystem.model.User;
import com.laundrysystem.repository.OrderRepository;
import com.laundrysystem.repository.UserRepository;

@Service
public class OrderService {

    // Get orders for a user by email
    public List<Order> getOrdersByUserEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        return orderRepository.findByUser(user);
    }

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    // Place order with custom status
    public Order placeOrder(Long userId, String status) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        Order order = new Order();
        order.setStatus(status);
        order.setUser(user);

        return orderRepository.save(order);
    }

    // Place order with default status PENDING
    public Order placeOrder(Long userId) {
        return placeOrder(userId, "PENDING");
    }

    // Get orders by status
    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
        // Place order with service and quantity
    public Order placeOrder(Long userId, String status, String service, int quantity) {
        return placeOrder(userId, status, service, quantity, "CASH", "PAY_ON_DELIVERY", 0);
    }

    public Order placeOrder(Long userId, String status, String service, int quantity, String paymentMethod, String paymentStatus, int totalAmount) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        Order order = new Order();
        order.setStatus(status);
        order.setService(service);
        order.setQuantity(quantity);
        order.setPaymentMethod(paymentMethod);
        order.setPaymentStatus(paymentStatus);
        order.setTotalAmount(totalAmount);
        order.setUser(user);

        return orderRepository.save(order);
    }

    // Update order status by ID
    public Order updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
        order.setStatus(status);
        return orderRepository.save(order);
    }

    // Delete order by ID
    public void deleteOrder(Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new RuntimeException("Order not found with id: " + orderId);
        }
        orderRepository.deleteById(orderId);
    }
}
