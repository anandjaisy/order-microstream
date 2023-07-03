package fete.bird;

import io.micronaut.core.annotation.NonNull;

import javax.validation.constraints.NotNull;

public interface IOrderRepository {
    Order create(@NonNull @NotNull Order fruit);
}
