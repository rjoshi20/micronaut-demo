package com.example;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.H2)
public interface OrderRepository extends CrudRepository<Order, Long> {

  @NonNull
  @Join(value = "customer")
  Optional<Order> findByCustomer(@NonNull @NotNull Customer customer);
}
