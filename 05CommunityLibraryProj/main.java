package main;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class main {

    public static void main(String[] args) {            //Main set for testing loans

        Library library = new Library();

        //library.readUsers();
        //library.readMags();
        //library.readRefBook();
        //library.readAudVid();
        //library.readBooks();
        //library.integrate();


        User user1 = new User("John", "11517 Flushwing Drive", "979-824-9001", 15);
        User user2 = new User("Annabel", "202 Mesquite Street", "979-841-1001", 8);
        User user3 = new User("Tom", "911 Hospital Lane", "999-954-1122", 98);
        User user4 = new User("Stacy", "11152 South Oak Valley Lane", "555-852-1325", 40);
        User user5 = new User("Rodrigo", "11517 Flushwing Drive", "979-824-9001", 15);

        library.addUser(user1);
        library.addUser(user2);
        library.addUser(user3);
        library.addUser(user4);
        library.addUser(user5);


        Book bookEx = new Book("Gone with the Wind", 12.19f, false);
        Book book1 = new Book("Harry Potter: The Deathly Hallows", 18.90f, false);
        Book book2 = new Book("Verity", 16.78f, true);
        Book book3 = new Book("A Tale of Two Cities", 7.00f, false);
        Book book4 = new Book("Elmo", 9.55f, false);
        Book book5 = new Book("Basic Book", 7.00f, false);
        Book book6 = new Book("Best Seller", 9.55f, true);
        Book book7 = new Book("OverDue30", 20.15f, false);
        Book book8 = new Book("OverDue$2.05", 2.05f, false);

        AudVid avEx = new AudVid("The Prince's new Groove", 8.90f);
        AudVid av1 = new AudVid("The Princess Bride", 6.89f);
        AudVid av2 = new AudVid("Planet Earth: Season 2 Episode 4", 4.56f);
        AudVid av3 = new AudVid("Carl Sagan: The Age of Exploration Lecture", 2.89f);
        AudVid av4 = new AudVid("City of San Marcos Documentary", 2.16f);


        ReferenceBook refBook1 = new ReferenceBook("Map of USA", 3.85f);
        ReferenceBook refBook2 = new ReferenceBook("How to Win Friends and Influence People", 4.99f);
        ReferenceBook refBook3 = new ReferenceBook("The Official ACT Prep Guide 2022-2023", 16.86f);
        ReferenceBook refBook4 = new ReferenceBook("The Elements of Style", 3.95f);
        ReferenceBook refBook5 = new ReferenceBook("Encyclopedia Britannica 2018 'F'", 29.90f);

        Magazine mag1 = new Magazine("Hot Rods", 18.99f);
        Magazine mag2 = new Magazine("Sports Illustrated", 3.27f);
        Magazine mag3 = new Magazine("Better Home and Gardens", 2.12f);
        Magazine mag4 = new Magazine("Game Informer", 5.34f);
        Magazine mag5 = new Magazine("Cosmopolitan", 3.69f);

        library.addItem(mag1);
        library.addItem(mag2);
        library.addItem(mag3);
        library.addItem(mag4);
        library.addItem(mag5);
        library.addItem(refBook1);
        library.addItem(refBook2);
        library.addItem(refBook3);
        library.addItem(refBook4);
        library.addItem(refBook5);
        library.addItem(bookEx);
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);
        library.addItem(book4);
        library.addItem(avEx);
        library.addItem(av1);
        library.addItem(av2);
        library.addItem(av3);
        library.addItem(av4);
        library.addItem(book5);
        library.addItem(book6);
        library.addItem(book7);
        library.addItem(book8);


        user2.requestItem(book5);
        user2.requestItem(book6);
        user2.requestItem(book7);
        user2.requestItem(book8);
        
        LocalDate today = LocalDate.now();
        LocalDate back30 = today.minusDays(30);
        book7.loan.changeDueDate(back30);
        book8.loan.changeDueDate(back30);
        user2.gatherFines(library);
        
        //userEx.checkInItem(book1);
        //userEx.requestItem(book2);
        //userEx.checkInItem(book2);
        //userEx.requestItem(book3);
        //userEx.checkInItem(book3);


        //String bookName = bookEx.getName();
        //float bookValue = bookEx.getValue();
        //boolean bookLoan = bookEx.isloanable();
        //boolean bookReq = bookEx.isRequested();
        //boolean bookAv = bookEx.isAvailable();
        //boolean bestSel = bookEx.isBestSeller();


        //String avName = avEx.getName();
        //float avValue = avEx.getValue();
        //boolean avLoan = avEx.isloanable();
        //boolean avReq = avEx.isRequested();
        //boolean avAv = avEx.isAvailable();

        //String refName = refBook.getName();
        //float refValue = refBook.getValue();
        //boolean refLoan = refBook.isloanable();
        //boolean refReq = refBook.isRequested();
        //boolean refAv = refBook.isAvailable();

        //String magName = mag.getName();
        //float magValue = mag.getValue();
        //boolean magLoan = mag.isloanable();
        //boolean magReq = mag.isRequested();
        //boolean magAv = mag.isAvailable();

        //String name = userEx.getName();
        //String address = userEx.getAddress();
        //String phoneNumber = userEx.getPhoneNumber();
        //int numItemsChecked = userEx.getNumItemsChecked();
        //int age = userEx.getAge();
        //int numItemsRequested = userEx.getNumItemsRequested();
        //double fines = userEx.getFines();
        //int ID = userEx.getID();
        //System.out.println("");
        //System.out.println("Name: " + name);
        //System.out.println("Address: " + address);
        //System.out.println("phone: " + phoneNumber);
        //System.out.println("ID: " + ID);
        //System.out.println("numItemsChecked : " + numItemsChecked);
        //System.out.println("age: " + age);
        //System.out.println("numItemsRequested: " + numItemsRequested);
        //System.out.println("fines: " + fines + "\n");

        //System.out.println("Name: " + bookName);
        //System.out.println("Value: " + bookValue);
        //System.out.println("BookLoan: " + bookLoan);
        //System.out.println("bookReq: " + bookReq);
        //System.out.println("bookAv : " + bookAv);
        //System.out.println("bestSel : " + bestSel);
        //System.out.println("StartDate : " + bookEx.loan.getStartDate());
        //System.out.println("DueDate : " + bookEx.loan.getDueDate());
        //System.out.println("Loaner : " + bookEx.loan.getLoaner());


        LibraryView libraryview = new LibraryView(library);


        //for (User user : library.users) {
            //library.getUserInfo(user.getID());
        //}

        //else {
        //System.out.println("Class Name: " + classString + "\n");
        //}

    }

}