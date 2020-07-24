package com.example;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class OrderRepositoryTest {

  @Inject
  CustomerRepository customerRepository;

  @Inject
  OrderRepository orderRepository;

  @Test
  public void shouldOrderByCustomer() {
    Customer customer = new Customer("Customer #1");
    customerRepository.save(customer);

    Order order = new Order(customer);
    orderRepository.save(order);

    Optional<Order> searchedOrder = orderRepository.findByCustomer(customer);
    assertTrue(searchedOrder.isPresent());
    assertEquals(order.getId(), searchedOrder.get().getId());
  }
}