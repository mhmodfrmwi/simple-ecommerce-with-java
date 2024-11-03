import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();

    public void add(Product product, int quantity) throws Exception {
        if (quantity > product.getProductQuantity()) {
            throw new Exception("there is no enough quantity of "+product.getName());
        }
        cartItems.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() { return cartItems; }
}
