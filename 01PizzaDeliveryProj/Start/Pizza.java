public class Pizza {
    public String ingrediants;
    public String address;
    public Pizza next;
    Pizza(String ingrediants, String address)
    {
        this.address = address;
        this.ingrediants = ingrediants;
        next = null;
    }
}
