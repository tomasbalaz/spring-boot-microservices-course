package sk.balaz.bookstore.orderservice.domain;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String message) {
        super(message);
    }

    public static OrderNotFoundException forCode(String code) {
        return new OrderNotFoundException("Order with number " + code + " not found");
    }
}
