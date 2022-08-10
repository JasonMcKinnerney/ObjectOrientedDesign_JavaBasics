public class SavingAccountV2 {
    private double Balance;
    public String AccountNumber;
    public double interestrate;
    //blah blah
    public void Deposit(double Amount) { Balance += Amount; }
    public void Withdraw(double Amount) { Balance -= Amount; }

    public double GetBalance() { return Balance; }   //<---- added a getter aka accessor
}
