public class SavingAccountV3 implements IAccount {
    private double Balance;
    public String AccountNumber;
    public double interest_rate;
    public void Deposit(double Amount) { Balance += Amount; }
    public void Withdraw(double Amount) { Balance -= Amount; }
    public double GetBalance() { return Balance; }
}
