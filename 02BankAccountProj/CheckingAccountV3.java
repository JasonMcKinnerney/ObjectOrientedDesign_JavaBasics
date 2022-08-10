public class CheckingAccountV3 implements IAccount{
    private double Balance;
    public String AccountNumber;
    public void Deposit(double Amount) { Balance += Amount; }
    public void Withdraw(double Amount) { Balance -= Amount; }
    public double GetBalance() { return Balance; }
}
