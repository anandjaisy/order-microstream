package fete.bird;

import io.micronaut.serde.annotation.Serdeable;

import java.util.UUID;

@Serdeable
public class Order {
    private UUID id;
    private String name;
    private String description;
    private String productId;

    public Order(UUID id, String name, String description, String productId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.productId = productId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
