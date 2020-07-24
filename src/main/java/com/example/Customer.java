package com.example;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;

import javax.persistence.Entity;

@Entity
public class Customer {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  public Customer(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Customer(String name) {
    this.name = name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
