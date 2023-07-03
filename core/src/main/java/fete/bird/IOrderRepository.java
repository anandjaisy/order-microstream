package fete.bird;

import fete.bird.model.Result;
import fete.bird.model.order.OrderDto;
import io.micronaut.core.annotation.NonNull;

import javax.validation.constraints.NotNull;

public interface IOrderRepository {
    Result<OrderDto> create(@NonNull @NotNull OrderDto order);
}
