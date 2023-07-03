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

    public OrderController(IServiceBus iServiceBus) {
        super(iServiceBus);
    }

    @Post
    @PermitAll
    OrderDto create(@NonNull @NotNull @Valid @Body OrderDto order) {
        var result = _iServiceBus.<OrderCreateCommand, Result<OrderDto>>send(new OrderCreateCommand(order));
        return result.value;
    }
}
