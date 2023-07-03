package fete.bird;

import io.micronaut.core.annotation.NonNull;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class RootContainer {
    @NonNull
    private final Map<UUID, Order> orders = new ConcurrentHashMap<>();

    @NonNull
    public Map<UUID, Order> getOrders() {
        return orders;
    }
}
