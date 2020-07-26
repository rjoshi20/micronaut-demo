package com.example;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

import static io.micronaut.data.annotation.Join.Type.LEFT_FETCH;

@JdbcRepository(dialect = Dialect.H2)
public interface OrderRepository extends CrudRepository<Order, Long> {

  @NonNull
  @Join(value = "customer", type = LEFT_FETCH)
  @Join(value = "address", type = LEFT_FETCH)
  Optional<Order> findByCustomer(@NonNull @NotNull Customer customer);

  @NonNull
  @Join(value = "customer", type = LEFT_FETCH)
  @Join(value = "address", type = LEFT_FETCH)
  Optional<Order> searchById(@NonNull @NotNull Long orderId);

  @NonNull
  @Join(value = "address", type = LEFT_FETCH)
  @Join(value = "customer", type = LEFT_FETCH)
  Optional<Order> findByCustomerName(@NonNull @NotNull String customerName);

  @NonNull
  @Join(value = "customer", type = LEFT_FETCH)
  Page<Order> findAll(Pageable page);
}
