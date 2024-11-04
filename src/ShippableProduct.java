import java.time.LocalDate;

public class ShippableProduct extends Product implements ShippingService {
    private int productWeight;
    private boolean requireShipping;
    public ShippableProduct(String productName, int productPrice,int productQuantity, int productWeight, boolean requireShipping) {
        super(productName, productPrice, productQuantity);
        this.productWeight = productWeight;
        this.requireShipping = requireShipping;
    }
    public ShippableProduct(String productName, int productPrice, int productQuantity, LocalDate productExpireDate, int productWeight, boolean requireShipping) {
        super(productName, productPrice, productQuantity, productExpireDate);
        this.productWeight = productWeight;
        this.requireShipping =   requireShipping;
    }

    public int getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(int productWeight) {
        this.productWeight = productWeight;
    }

    @Override
    public String getName() {
        return getProductName();
    }

    @Override
    public double getWeight() {
        return productWeight;
    }

    public boolean isRequireShipping() {
        return requireShipping;
    }
}
