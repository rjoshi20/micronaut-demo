package com.example;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Order {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private Customer customer;

  @ManyToOne
  private Address address;

  public Order() {
  }

  public Order(Customer customer, Address address) {
    this.customer = customer;
    this.address = address;
  }

  public Order(Customer customer) {
    this.customer = customer;
  }

  public Order(Address address) {
    this.address = address;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return Objects.equals(id, order.id) &&
      Objects.equals(customer, order.customer) &&
      Objects.equals(address, order.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, customer, address);
  }
}
