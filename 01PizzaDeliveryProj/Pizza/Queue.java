public class Queue {
    public Pizza head;
    public Pizza tail;

    public void enqueue(Pizza thispizza)
    {
        if (head == null) head = thispizza;
        else tail.next = thispizza;
        tail = thispizza;
        return;
    }

    public Pizza dequeue()
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

    public void deliver()
    {
        Pizza thispizza = dequeue();
        if (thispizza == null)
        {
            System.out.println("No deliveries pending"); return;
        }
        System.out.print("Deliver a pizza with ");
        System.out.print(thispizza.ingredients);
        System.out.print(" to ");
        System.out.println(thispizza.address);
    }
}
