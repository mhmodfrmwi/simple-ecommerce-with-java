public class Checkout {
    public void checkout(Customer customer, Cart cart) throws Exception {
        if (cart.getItems().isEmpty()) throw new Exception("Cart is empty.");

        double subtotal = calculateSubtotal(cart);
        double shippingFee = calculateShippingFee(cart);
        double totalWeight = calculateTotalWeight(cart);

        printShipmentNotice(cart, totalWeight);
        printCheckoutReceipt(cart);

        double totalAmount = subtotal + shippingFee;
        customer.pay(totalAmount);

        printFinalSummary(subtotal, shippingFee, totalAmount, customer);
    }

    private double calculateSubtotal(Cart cart) throws Exception {
        double subtotal = 0;
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            validateProduct(product);
            subtotal += item.getQuantity() * product.getProductPrice();
        }
        return subtotal;
    }

    private double calculateShippingFee(Cart cart) {
        double shippingFee = 0;
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (product.isRequireShipping()) {
                shippingFee += item.getQuantity() * (product.getProductPrice() * 0.03);
            }
        }
        return shippingFee;
    }

    private double calculateTotalWeight(Cart cart) {
        double totalWeight = 0;
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            totalWeight += item.getQuantity() * product.getProductWeight();
        }
        return totalWeight;
    }

    private void validateProduct(Product product) throws Exception {
        if (product.isExpired()) throw new Exception(product.getProductName() + " is expired.");
    }

    private void printShipmentNotice(Cart cart, double totalWeight) {
        System.out.println("** Shipment notice **");
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (product.isRequireShipping()) {
                System.out.println(item.getQuantity() + "x " + product.getProductName() + "        " + product.getProductWeight()* item.getQuantity() + "g");
            }
        }
        System.out.printf("Total package weight: %.2f kg%n%n", totalWeight / 1000);
    }

    private void printCheckoutReceipt(Cart cart) {
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getProductName() + "        " + item.getProduct().getProductPrice()* item.getQuantity());
        }
    }

    private void printFinalSummary(double subtotal, double shippingFee, double totalAmount, Customer customer) {
        System.out.println("---------------------------");
        System.out.println("Subtotal:   " + subtotal);
        System.out.println("Shipping:   " + shippingFee);
        System.out.println("Amount Paid: " + totalAmount);
        System.out.println("Remaining Balance: " + customer.getBalance());
    }

}
