public class Customer {
    private int balance;
    public Customer( int balance) {
        this.balance = balance;
    }
    public int getBalance() {
        return balance;
    }
    public void pay(double amount) throws Exception {
        if (amount > balance)
            throw new Exception("Insufficient balance.");
        balance -= amount;
    }
}
