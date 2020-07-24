package com.example;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Order {

  @Id
  @GeneratedValue
  private Long id;

  public Order() {
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  @ManyToOne
  private Customer customer;

  public Order(Long id, Customer customer) {
    this.id = id;
    this.customer = customer;
  }

  public Order(Customer customer) {
    this.customer = customer;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

}
