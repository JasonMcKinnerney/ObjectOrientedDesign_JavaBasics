public class Main {

    public static void main(String[] args)
    {
        Q q1 = new Q();

        enqueue(q1, new Pizza("pepperoni", "1234 Bobcat Trail"));
        enqueue(q1, new Pizza("sausage", "2345 University Drive"));
        deliver(q1);
        enqueue(q1, new Pizza("extra cheese", "3456 Rickster Road"));
        enqueue(q1, new Pizza("everything", "4567 King Court"));
        enqueue(q1, new Pizza("coffee beans", "5678 Java Circle"));
        deliver(q1);
        deliver(q1);
        deliver(q1);
        deliver(q1);
        deliver(q1);
    }

    public static void enqueue(Q q, Pizza thispizza)
    {
        if (q.head == null) q.head = thispizza;
        else q.tail.next = thispizza;
        q.tail = thispizza;
        return;
    }

    public static Pizza dequeue(Q q)
    {
        Pizza pizzatodeliver = null;
        if (q.head != null)
        {
            pizzatodeliver = q.head;
            q.head = q.head.next;
        }
        if (q.head == null) q.tail = null;
        return pizzatodeliver;
    }

    public static void deliver(Q q)
    {
        Pizza thispizza = dequeue(q);
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

