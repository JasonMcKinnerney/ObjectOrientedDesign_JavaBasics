public class Main {

    public static void main(String[] args)
    {
        Pizza first = null, last = null;

        enqueue(first, last, new Pizza("pepperoni", "1234 Bobcat Trail"));
        enqueue(first, last, new Pizza("sausage", "2345 University Drive"));
        deliver(first, last);
        enqueue(first, last, new Pizza("extra cheese", "3456 Rickster Road"));
        enqueue(first, last, new Pizza("everything", "4567 King Court"));
        enqueue(first, last, new Pizza("coffee beans", "5678 Java Circle"));
        deliver(first, last);
        deliver(first, last);
        deliver(first, last);
        deliver(first, last);
        deliver(first, last);
    }

    public static void enqueue(Pizza head, Pizza tail, Pizza thispizza)
    {
        if (head == null) head = thispizza;
	    else tail.next = thispizza;
	    tail = thispizza;
        return;
    }

    public static Pizza dequeue(Pizza head, Pizza tail)
    {
        Pizza pizzatodeliver = null;
        if (head != null)
        {
            pizzatodeliver = head;
		    head = head.next;
        }
        if (head == null) tail = null;
        return pizzatodeliver;
    }

    public static void deliver(Pizza head, Pizza tail)
    {
        Pizza thispizza = dequeue(head, tail);
        if (thispizza == null)
        {
            System.out.println("No deliveries pending"); return;
        }
        System.out.print("Deliver a pizza with ");
        System.out.print(thispizza.ingrediants);
        System.out.print(" to ");
        System.out.println(thispizza.address);
    }
}
