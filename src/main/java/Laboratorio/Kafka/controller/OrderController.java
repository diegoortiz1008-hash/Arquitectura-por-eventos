@RestController
@RequestMapping("/orders")
public class OrderController {
 private final OrderEventProducer producer;
 public OrderController(OrderEventProducer producer) {
 this.producer = producer;
 }
 @PostMapping
 @ResponseStatus(HttpStatus.CREATED)
 public OrderCreatedEvent createOrder(@RequestBody CreateOrderRequest request) {
 OrderCreatedEvent event = new OrderCreatedEvent(
 "ORD-" + UUID.randomUUID(),
 request.getCustomerId(),
 request.getTotal(),
 "CREATED",
 Instant.now()
 );
 producer.publishOrderCreated(event);
 return event;
 }
}