public class Pizza {
    public String ingredients;
    public String address;
    public Pizza next;
    
    
    Pizza(String ingredients, String address)
    {
        this.address = address;
        this.ingredients = ingredients;
        next = null;
    }
}
