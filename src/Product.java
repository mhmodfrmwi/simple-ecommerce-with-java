import java.time.LocalDate;

public class Product {
    private String productName;
    private int productPrice;
    private int productQuantity;
    private LocalDate productExpireDate;
    public Product(String productName, int productPrice, int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }
    public Product(String productName, int productPrice, int productQuantity, LocalDate productExpireDate) {
        this(productName, productPrice, productQuantity);
        this.productExpireDate = productExpireDate;
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

    public LocalDate getProductExpireDate() {
        return productExpireDate;
    }

    public void setProductExpireDate(LocalDate productExpireDate) {
        this.productExpireDate = productExpireDate;
    }

    public boolean isExpired() {
        return productExpireDate != null && productExpireDate.isBefore(LocalDate.now());
    }
}
