package com.example;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class OrderRepositoryTest {

  @Inject
  CustomerRepository customerRepository;

  @Inject
  AddressRepository addressRepository;

  @Inject
  OrderRepository orderRepository;

  @Test
  public void shouldFetchOrderWithoutCustomer() {
    Order order1 = new Order();
    orderRepository.save(order1);

    Optional<Order> fetchedOrder = orderRepository.findById(order1.getId());

    assertTrue(fetchedOrder.isPresent());
    assertNotNull(fetchedOrder.get());
  }

  @Test
  public void findByCustomerShouldGetOrderWithCustomer() {
    Customer customer = new Customer("Customer #1");
    customerRepository.save(customer);

    Order order = new Order(customer);
    orderRepository.save(order);

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    Order searchedOrder = orderRepository.findByCustomer(customer).get();
    assertEquals(order.getId(), searchedOrder.getId());
    assertEquals(customer, searchedOrder.getCustomer());
  }

  @Test
  public void searchByIdShouldReturnOrderWithAddress() {
    Address address = new Address("22001");
    addressRepository.save(address);

    Order order = new Order(address);
    orderRepository.save(order);

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    Order searchedOrder = orderRepository.searchById(order.getId()).get();
    assertEquals(order.getId(), searchedOrder.getId());
    assertEquals(address, searchedOrder.getAddress());
  }

  @Test
  public void findByCustomerNameShouldReturnOrderWithCustomer() {
    Customer customer = new Customer("Customer #1");
    customerRepository.save(customer);

    Order order = new Order(customer, null);
    orderRepository.save(order);

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    Order searchedOrder = orderRepository.findByCustomerName("Customer #1").get();

    assertEquals(order.getId(), searchedOrder.getId());
    assertEquals(customer, searchedOrder.getCustomer());
  }
}