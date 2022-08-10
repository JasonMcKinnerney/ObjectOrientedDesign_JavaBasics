package main;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.io.*;

import javax.swing.*;

//need method to return item specific fines, getFine()
//need method to return item specific due date, getDueDate()

public class Library extends JFrame implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

    //List of Item objects, can be book, magazine, etc..
    public ArrayList<Item> items;
    //List of User objects, has name, address, etc..
    public ArrayList<User> users;
    public ArrayList<Book> books;
    public ArrayList<AudVid> audvids;
    public ArrayList<Magazine> mags;
    public ArrayList<ReferenceBook> refbooks;
    private int userID = 10001;

    //Generic Constructor
    public Library() {
        this.users = new ArrayList<>();
        this.items = new ArrayList<>();
        this.books = new ArrayList<>();
        this.audvids = new ArrayList<>();
        this.mags = new ArrayList<>();
        this.refbooks = new ArrayList<>();
    }

    public void addUser(User x){
        x.setID(userID);
        users.add(x);
        userID++;
    }

    public void addItem(Item y){
        Book bookEx = new Book("1", 9.55f, false);
        AudVid avEx = new AudVid("1", 1.50f);
        ReferenceBook refBook = new ReferenceBook("Map", 3.85f);
        Magazine mag = new Magazine("Ex", 19.99f);
        if (y.getClass() == bookEx.getClass()) {
            books.add((Book) y);
        }
        else if (y.getClass() == avEx.getClass()) {
            audvids.add((AudVid) y);
        }
        else if (y.getClass() == refBook.getClass()) {
            refbooks.add((ReferenceBook) y);
        }
        else {
            mags.add((Magazine) y);
        }
        items.add(y);

    }

    public ArrayList<User> getUserList(){
        return users;
    }

    public ArrayList<Item> getItemList(){
        return items;
    }

    public void getUserInfo(int libraryCardNum){
        User tempUser;
        int tempID;
        boolean flag = false;
        for(int x = 0; x < users.size(); x++) {
            tempUser = users.get(x);
            tempID = tempUser.getID();
            if(tempID == libraryCardNum){
                System.out.println("User found.\n");
                System.out.println("Name: ");
                System.out.println(tempUser.getName() + "\n");
                System.out.println("Address: ");
                System.out.println(tempUser.getAddress() + "\n");
                System.out.println("Phone Number: ");
                System.out.println(tempUser.getPhoneNumber() + "\n");
                System.out.println("Library Card Number: ");
                System.out.println(libraryCardNum + "\n");
                flag = true;
            }
        }
        if (flag != true) {
            System.out.println("User not found. Please enter a valid ID.");
        }
    }

    public void getItemInfo(String name){
        Item tempItem;
        String tempName;
        boolean flag = false;
        for(int x = 0; x < items.size(); x++) {
            tempItem = items.get(x);
            tempName = tempItem.getName();
            if(tempName == name){
                System.out.println("Item found.\n");
                System.out.println("Name: ");
                System.out.println(tempItem.getName() + "\n");
                System.out.println("Value: ");
                System.out.println(tempItem.getValue() + "\n");
                System.out.println("Loanability: ");
                System.out.println(tempItem.isloanable() + "\n");
                System.out.println("Availability: ");
                System.out.println(tempItem.isAvailable() + "\n");
                flag = true;
            }
        }
        if (flag != true) {
            System.out.println("Item not found. Please enter a valid item name.");
        }
    }

    public void writeBooks() {
        String filename = "books.bin";
        // Serialization
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            for (Book book : this.books) {
                out.writeObject(book);
            }

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

    }

    public void addBook(Book y){
        books.add(y);
    }


    public void readBooks() {
        String filename = "books.bin";
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            while(true) {
                addBook((Book) in.readObject());
            }


        }
        catch(Exception e) {}


        System.out.println("Object has been deserialized ");
    }

    public void writeUsers() {
        String filename = "users.bin";
        // Serialization
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            for (User user : this.users) {
                out.writeObject(user);
            }

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

    }


    public void readUsers() {
        String filename = "users.bin";
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            while(true) {
                addUsers((User) in.readObject());
            }

        }
        catch(Exception e) {}


        System.out.println("Object has been deserialized ");
    }

    public void addUsers(User y){
        users.add(y);
    }

    public void writeAudVid() {
        String filename = "AudVid.bin";
        // Serialization
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            for (AudVid av : this.audvids) {
                out.writeObject(av);
            }

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

    }

    public void readAudVid() {
        String filename = "AudVid.bin";
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            while(true) {
                addAudVid((AudVid) in.readObject());
            }

        }
        catch(Exception e) {}


        System.out.println("Object has been deserialized ");
    }

    public void addAudVid(AudVid y){
        audvids.add(y);
    }

    public void writeMags() {
        String filename = "Mags.bin";
        // Serialization
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            for (Magazine mag : this.mags) {
                out.writeObject(mag);
            }

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

    }

    public void readMags() {
        String filename = "Mags.bin";
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            while(true) {
                addMags((Magazine) in.readObject());
            }

        }
        catch(Exception e) {}


        System.out.println("Object has been deserialized ");
    }

    public void addMags(Magazine y){
        mags.add(y);
    }

    public void writeRefBook() {
        String filename = "RefBook.bin";
        // Serialization
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            for (ReferenceBook refbook : this.refbooks) {
                out.writeObject(refbook);
            }

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

    }

    public void readRefBook() {
        String filename = "RefBook.bin";
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            while(true) {
                addRefBook((ReferenceBook) in.readObject());
            }

        }
        catch(Exception e) {}


        System.out.println("Object has been deserialized ");
    }

    public void addRefBook(ReferenceBook y){
        refbooks.add(y);
    }

    public void integrate() {
        for (ReferenceBook refbook : this.refbooks) {
            items.add(refbook);
        }
        for (Magazine mag : this.mags) {
            items.add(mag);
        }
        for (Book book: this.books) {
            items.add(book);
        }
        for (AudVid av : this.audvids) {
            items.add(av);
        }
    }
}