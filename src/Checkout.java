public class Checkout {
    public void checkout(Customer customer, Cart cart) throws Exception {
        double subtotal = 0;
        double shippingFee = 0;
        double totalWeight = 0;

        if (cart.getItems().isEmpty()) throw new Exception("Cart is empty.");
        System.out.println("** Shipment notice **");
        for (CartItem item : cart.getItems()) {
            if (item.getProduct().isExpired()) throw new Exception(item.getProduct().getName() + " is expired.");
            totalWeight+=item.getProduct().getWeight();
            subtotal+=item.getQuantity()*item.getProduct().getProductPrice();
            if (item.getProduct().isRequireShipping())shippingFee+=item.getQuantity()*(item.getProduct().getProductPrice()*.03);
            System.out.println(item.getQuantity()+"x "+item.getProduct().getName()+"        "+item.getProduct().getWeight()+"g");
        }
        System.out.println("Total package weight "+totalWeight/1000+"kg\n");

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity()+"x "+item.getProduct().getName()+"        "+item.getProduct().getProductPrice());
        }

        double totalAmount = subtotal + shippingFee;
        customer.pay(totalAmount);

        System.out.println("---------------------------");
        System.out.println("Subtotal:   " + subtotal);
        System.out.println("Shipping:   " + shippingFee);
        System.out.println("Amount Paid: " + totalAmount);
        System.out.println("Remaining Balance: " + customer.getBalance());
    }
}
