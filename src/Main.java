import java.time.LocalDate;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product scratchCard=new Product("Scratch card",50,3);
        Product biscuits=new Product("Biscuits",50,3,LocalDate.now().plusDays(30));
        ShippableProduct cheese = new ShippableProduct("Cheese", 20, 15, LocalDate.now().plusDays(30),100,true);
        ShippableProduct tv = new ShippableProduct("TV", 500, 5,200,true);
        Customer customer = new Customer(1000);
        try {
            Cart cart = new Cart();
            cart.add(cheese, 2);
            cart.add(tv, 1);
            cart.add(scratchCard,2);
            cart.add(biscuits,2);
            Checkout checkoutService = new Checkout();
            checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}