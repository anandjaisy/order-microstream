package fete.bird;

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
    public Order create(Order order) {
        Map<UUID, Order> root = rootProvider.root().getOrders();
        return performCreate(root, order);
    }

    @StoreParams("root")
    protected Order performCreate(Map<UUID, Order> root, Order Order) {
        root.put(Order.getId(), Order);
        return Order;
    }
}
