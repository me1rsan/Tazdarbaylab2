public class ECommerceSystem {
    public static void main(String[] args) {
        Admin admin1 = new Admin(1, "Admin One", "admin1@gmail.com");
        Admin admin2 = new Admin(2, "Admin Two", "admin2@gmail.com");

        Product product1 = new Product("P1", "cake", 5000.0, 10);
        Product product2 = new Product("P2", "cookie", 800.0, 15);
        Product product3 = new Product("P3", "chocolate", 550.0, 30);

        admin1.addProduct(product1);
        admin1.addProduct(product2);
        admin2.addProduct(product3);

        Customer customer1 = new Customer(101, "Anuar", "anuar@gmail.com", "Kalina 39");
        Customer customer2 = new Customer(102, "Tamerlan", "tamerlan@gmail.com", "Kilik 34");

        customer1.placeOrder(product1, 2);
        customer1.placeOrder(product2, 1);
        customer2.placeOrder(product3, 5);
        customer2.placeOrder(product1, 15); // Exceeding stock

        admin1.updateStock("P1", 20);

        customer2.placeOrder(product1, 5);

        customer1.displayDetails();
        customer2.displayDetails();

        admin1.displayDetails();
        admin2.displayDetails();

        product1.displayDetails();
        product2.displayDetails();
        product3.displayDetails();
    }
}