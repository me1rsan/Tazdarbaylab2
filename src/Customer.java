import java.util.List;
import java.util.ArrayList;

class Customer extends User {
    private List<Order> orders;
    private String shippingAddress;
    private static int orderCounter = 1;

    public Customer(int userId, String name, String email, String shippingAddress) {
        super(userId, name, email);
        this.shippingAddress = shippingAddress;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Product product, int quantity) {
        if (product.getStock() < quantity) {
            System.out.println("Insufficient stock for product: " + product.getName());
            return;
        }
        String orderId = "ORD" + (orderCounter++);
        Order order = new Order(orderId, this, product, quantity, product.getPrice() * quantity, "Placed");
        orders.add(order);
        product.reduceStock(quantity);
        System.out.println("Order placed: " + orderId);
    }

    public void cancelOrder(Order order) {
        if (orders.contains(order) && order.getStatus().equals("Placed")) {
            order.cancelOrder();
            orders.remove(order);
            System.out.println("Order cancelled: " + order.getOrderId());
        } else {
            System.out.println("Order cannot be cancelled: " + order.getOrderId());
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Customer ID: " + userId + ", Name: " + name + ", Email: " + email + ", Address: " + shippingAddress);
    }
}