public class GenericAccount {
    private double Balance;
    public void Deposit(double Amount) { Balance += Amount; }
    public void Withdraw(double Amount) { Balance -= Amount; }
    public double GetBalance() { return Balance; }
}