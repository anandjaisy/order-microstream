package fete.bird;

import fete.bird.model.Result;
import fete.bird.model.order.OrderDto;
import fete.bird.utils.IServiceBus;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.annotation.security.PermitAll;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller("/order")
public class OrderController extends BaseController{
    private final IOrderRepository iOrderRepository;

    public OrderController(IServiceBus iServiceBus, IOrderRepository iOrderRepository) {
        super(iServiceBus);
        this.iOrderRepository = iOrderRepository;
    }

    @Post
    @PermitAll
    OrderDto create(@NonNull @NotNull @Valid @Body Order order) {
        var result = _iServiceBus.<OrderCreateCommand, Result<OrderDto>>send(new OrderCreateCommand());
        var test = iOrderRepository.create(order);
        return result.value;
    }
}
