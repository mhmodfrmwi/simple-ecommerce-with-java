import java.time.LocalDate;

public class Product implements ShippingService {
    private String productName;
    private int productPrice;
    private int productWeight;
    private int productQuantity;
    private LocalDate productExpireDate;
    private boolean requireShipping;
    public Product( String productName, int productPrice, int productQuantity, LocalDate productExpireDate, boolean requireShipping, int productWeight) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.requireShipping = requireShipping;
        this.productExpireDate = productExpireDate;
        this.productWeight = productWeight;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
    public int getProductQuantity() {
        return productQuantity;
    }
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
    public void reduceProductQuantity(int productQuantity) {
        this.productQuantity -= productQuantity;
    }
    public LocalDate  getProductExpireDate() {
        return productExpireDate;
    }

    public void setProductExpireDate(LocalDate  productExpireDate) {
        this.productExpireDate = productExpireDate;
    }
    public boolean isExpired(){
        return productExpireDate != null && productExpireDate.isBefore(LocalDate.now());
    }
    public boolean isRequireShipping() {
        return requireShipping;
    }

    public void setRequireShipping(boolean requireShipping) {
        this.requireShipping = requireShipping;
    }

    public int getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(int productWeight) {
        this.productWeight = productWeight;
    }

    @Override
    public String getName() {
        return productName;
    }

    @Override
    public double getWeight() {
        return productWeight;
    }
}
