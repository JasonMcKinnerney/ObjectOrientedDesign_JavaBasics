public class CheckingAccountV1 {
    public double Balance;
    public String AccountNumber;
    //blah blah
    public void Deposit(double Amount) {
        Balance += Amount;
    }
    public void Withdraw(double Amount) {
        Balance -= Amount;
    }
}
