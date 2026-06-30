@Service
public class OrderEventProducer {
 private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;
 public OrderEventProducer(KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
 this.kafkaTemplate = kafkaTemplate;
 }
 public void publishOrderCreated(OrderCreatedEvent event) {
 kafkaTemplate.send("orders", event.getOrderId(), event);
 }
}