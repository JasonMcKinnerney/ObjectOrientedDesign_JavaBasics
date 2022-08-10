package main;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class User implements java.io.Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String name;
    private String address;
    private String phoneNumber;
    private int ID;
    private ArrayList<String> ItemsCheckedOut;
    private int age;
    private ArrayList<String> ItemsRequested;
    private double fines;
    

    public User(String name1, String address1, String phoneNumber1, int Age) {
        this.setName(name1);
        this.setAddress(address1);
        this.setPhoneNumber(phoneNumber1);
        this.setAge(Age);
        this.fines = 0;
        this.ItemsCheckedOut = new ArrayList<>();
        this.ItemsRequested = new ArrayList<>();
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public int getID() {
        return ID;
    }


    public void setID(int iD) {
        ID = iD;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public ArrayList<String> getItemsCheckedOut () {return ItemsCheckedOut;}


    public int getNumItemsChecked() {
        return this.ItemsCheckedOut.size();
    }


    public int getNumItemsRequested() {
        return this.ItemsRequested.size();
    }

    public void addItemChecked(Item item) {
        this.ItemsCheckedOut.add(item.getName());
    }

    public void remItemChecked(Item item) {
        this.ItemsCheckedOut.remove(item.getName());
    }

    public void addItemRequested(Item item) {
        this.ItemsRequested.add(item.getName());
    }

    public void remItemRequested(Item item) {
        this.ItemsRequested.remove(item.getName());
    }


    public double getFines() {
        return fines;
    }
    
    public void addFines(double x) {
        this.fines = this.fines + x;
    }
    public void gatherFines(Library library) {
    	for (String x : this.ItemsCheckedOut) {
    		for (Item item : library.items) {
    			if (x.equals(item.getName())) {
    				double y = item.loan.calculateFine(item);
    				this.addFines(y);
    			}
    		}
    	}    	
    }
    
    public void payFines(double x) {
        this.fines = this.fines - x;
        BigDecimal bd = new BigDecimal(this.fines).setScale(2, RoundingMode.HALF_UP);
        this.fines = bd.doubleValue();
        if(this.fines - x >= 0) {
            this.fines = this.fines - x;
            BigDecimal a = new BigDecimal(this.fines).setScale(2, RoundingMode.HALF_UP);
            this.fines = bd.doubleValue();
        }
    }

    public String requestItem(Item item) {
        String message = "Error";
        if (this.age <= 12) {
            if (this.ItemsCheckedOut.size() == 5) {
                message ="Maximum number of Items checked out \n";
            }
            else if (!item.isloanable()) {
                message = "This item cannot be checked out";
            }
            else if (item.isAvailable()) {
                item.setLoan(this);
                item.setAvailable(false);
                this.addItemChecked(item);
                this.remItemRequested(item);
                message ="Item has been checked out";
            } else {
                item.setRequested(true);
                this.addItemRequested(item);
                message = "This item is not available, Item is now Requested";
            }
            return message;
        }
        else if (!item.isloanable()) {
            message = "This item cannot be checked out";
        }
        else if (item.isAvailable()){
            item.setLoan(this);
            item.setAvailable(false);
            this.addItemChecked(item);
            this.remItemRequested(item);
            message = "Item has been checked out";
        }
        else {
            item.setRequested(true);
            this.addItemRequested(item);
            message = "This item is not available, Item is now Requested";
        }
        return message;
    }

    public String renewItem(Item item) {
        if(!item.isRequested()) {
            String message = item.loan.setRenewed(item);
            return message;
        } else {
            String message = "Item is requested, please return by " + item.loan.getDueDate();
            return message;
        }
    }

    public String checkInItem(Item item) {
        this.addFines((item.loan.calculateFine(item)));
        item.loan.remLoanData(item);
        this.remItemChecked(item);
        item.setAvailable(true);
        item.setRequested(false);
        String message = "Item Checked in";
        return message;
    }
}