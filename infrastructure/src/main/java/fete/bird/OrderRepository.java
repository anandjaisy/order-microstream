package fete.bird;

import fete.bird.model.Result;
import fete.bird.model.order.OrderDto;
import io.micronaut.microstream.RootProvider;
import io.micronaut.microstream.annotations.StoreParams;
import jakarta.inject.Singleton;

import java.util.Map;
import java.util.UUID;

@Singleton
public class OrderRepository implements IOrderRepository{
    private final RootProvider<RootContainer> rootProvider;

    public OrderRepository(RootProvider<RootContainer> rootProvider) {
        this.rootProvider = rootProvider;
    }

    @Override
    public Result<OrderDto> create(OrderDto order) {
        Map<UUID, Order> root = rootProvider.root().getOrders();
        return performCreate(root, new Order(order.id(), order.name(), order.description(), order.productId()));
    }

    @StoreParams("root")
    protected Result<OrderDto> performCreate(Map<UUID, Order> root, Order order) {
        root.put(order.getId(), order);
        return new Result<>(new OrderDto(order.getId(), order.getName(), order.getDescription(), order.getProductId()));
    }
}
