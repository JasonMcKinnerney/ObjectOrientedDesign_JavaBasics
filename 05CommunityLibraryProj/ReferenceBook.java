package main;
public class ReferenceBook extends Item {

    private static final long serialVersionUID = 1L;

    public ReferenceBook(String a, float b) {
        super(a, b);
        this.loanable = false;
    }
}