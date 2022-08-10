public class CheckingAccountV2 {
    private double Balance;
    public String AccountNumber;
    //blah blah
    public void Deposit(double Amount) { Balance += Amount; }
    public void Withdraw(double Amount) { Balance -= Amount; }

    public double GetBalance() { return Balance; }   //<---- added a getter aka accessor
}
