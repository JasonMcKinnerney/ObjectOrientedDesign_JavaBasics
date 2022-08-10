package main;
import java.io.*;

public class Item implements java.io.Serializable{


	private static final long serialVersionUID = 1L;
	//name of item
	protected String name;

	//value of the item
	protected float valueOfItem;

	//qualifier if the item is loanable
	//default is set at 1, unless item is a magazine or reference book
	protected boolean loanable;

	//boolean to determine whether the item is requested
	//default is 0
	protected boolean requested;

	//boolean to determine whether the item is available
	//default is 1
	protected boolean available;

	//boolean to determine whether the item is restricted
	//default is 0
	protected boolean restricted;

	protected Loans loan;


	public Item(String a,float b){
		name = a;
		valueOfItem = b;
		requested = false;
		available = true;
	}


	//getters for
	public String getName() {
		return name;
	};

	public float getValue() {
		return valueOfItem;
	};

	public boolean isloanable() {
		return loanable;
	};

	public boolean isRequested() {
		return requested;
	};

	public boolean isAvailable() {
		return available;
	};

	public void setRequested(boolean setter) {
		this.requested = setter;
	};

	public void setAvailable(boolean setter) {
		this.available = setter;
	};

	public void setLoan(User x) {
		this.loan = new ShortTermLoan(x, this);
	}
}