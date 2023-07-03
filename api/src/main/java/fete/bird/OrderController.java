package fete.bird;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller("/order")
public class OrderController {
    private final IOrderRepository iOrderRepository;

    public OrderController(IOrderRepository iOrderRepository) {
        this.iOrderRepository = iOrderRepository;
    }

    @Post
    Order create(@NonNull @NotNull @Valid @Body Order order) {
        return iOrderRepository.create(order);
    }
}
