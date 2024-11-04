public class CartItem {
    private Product product; // Accepts both Product and ShippableProduct
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isShippable() {
        return product instanceof ShippableProduct;
    }

    public ShippableProduct getShippableProduct() {
        if (isShippable()) {
            return (ShippableProduct) product;
        }
        throw new IllegalStateException("Product does not require shipping.");
    }
}
