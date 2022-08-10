package main;
public class Magazine extends Item {


    private static final long serialVersionUID = 1L;

    public Magazine(String a, float b) {
        super(a, b);
        this.loanable = false;
    }

}