import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product cheese = new Product("Cheese", 100, 10,LocalDate.now().plusDays(50),true,200);
        Product tv = new Product("TV", 500, 5,LocalDate.now(),true,200);
        Customer customer = new Customer(500);
        try {
            Cart cart = new Cart();
            cart.add(cheese, 2);
            cart.add(tv, 1);

            Checkout checkoutService = new Checkout();
            checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}