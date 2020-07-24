package com.example;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class CustomerRepositoryTest {

  @Inject
  CustomerRepository customerRepository;

  @Test
  public void shouldFetchCustomer() {
    customerRepository.save(new Customer("Customer #1"));

    assertNotNull(customerRepository.findByName("Customer #1"));
  }
}