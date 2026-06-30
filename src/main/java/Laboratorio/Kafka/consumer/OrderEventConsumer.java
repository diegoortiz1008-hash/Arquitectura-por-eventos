@Service
public class OrderEventConsumer {
 @KafkaListener(topics = "orders", groupId = "inventory-service")
 public void consume(OrderCreatedEvent event) {
 System.out.println("Evento recibido en inventory-service: " + event.getOrderId());
 }
}