package fete.bird;

import fete.bird.model.Result;
import fete.bird.model.order.OrderDto;
import fete.bird.utils.ICommandQueryHandler;
import io.micronaut.core.annotation.Introspected;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

@Introspected
public record OrderCreateCommand(OrderDto orderDto) {
    @Singleton
    public record CreateOrderHandler(IOrderRepository iOrderRepository) implements ICommandQueryHandler<OrderCreateCommand, Result<OrderDto>> {
        private static final Logger LOG = LoggerFactory.getLogger(CreateOrderHandler.class);
        @Override
        public Result<OrderDto> handler(OrderCreateCommand orderCreateCommand) {
            LOG.info("Command: Create the new order");
            return iOrderRepository.create(orderCreateCommand.orderDto);
        }

        @Override
        public Class<OrderCreateCommand> commandType() {
            return OrderCreateCommand.class;
        }
    }
}
