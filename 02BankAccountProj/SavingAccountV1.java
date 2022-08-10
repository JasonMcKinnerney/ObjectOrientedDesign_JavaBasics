public class SavingAccountV1 {
    public double Balance;
    public String AccountNumber;
    public double interestrate;
    //blah blah
    public void Deposit(double Amount) {
        Balance += Amount;
    }
    public void Withdraw(double Amount) {
        Balance -= Amount;
    }
}
