package main;
public class AudVid extends Item {


    private static final long serialVersionUID = 1L;
    private boolean renewed;

    public AudVid(String a, float b) {
        super(a, b);
        this.loanable = true;
        this.renewed = false;
    }

    public boolean isRenewed() {
        return renewed;
    }

    public void setRenewed(boolean renewed) {
        this.renewed = renewed;
    }
}