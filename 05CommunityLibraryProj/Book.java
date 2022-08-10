package main;
public class Book extends Item {

    private static final long serialVersionUID = 1L;
    private boolean bestSeller;
    private boolean renewed;

    public Book(String a, float b, boolean c) {
        super(a, b);
        this.loanable = true;
        this.bestSeller = c;
        this.renewed = false;

    }

    public boolean isBestSeller() {
        return this.bestSeller;
    }

    public void setBestSeller(boolean x) {
        this.bestSeller = x;
    }

    public boolean isRenewed() {
        return renewed;
    }

    public void setRenewed(boolean renewed) {
        this.renewed = renewed;
    };

    @Override public void setLoan(User x) {
        if (this.bestSeller == true) {
            this.loan = new ShortTermLoan(x, this);
        }
        else {
            this.loan = new LongTermLoan(x, this);
        }
    }

}