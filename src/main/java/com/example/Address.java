package com.example;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Address {

  @Id
  @GeneratedValue
  private Long id;

  private String zipcode;

  public Address(Long id, String zipcode) {
    this.id = id;
    this.zipcode = zipcode;
  }

  public Address(String zipcode) {
    this.zipcode = zipcode;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public String getZipcode() {
    return zipcode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Address address = (Address) o;
    return Objects.equals(id, address.id) &&
      Objects.equals(zipcode, address.zipcode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, zipcode);
  }
}
