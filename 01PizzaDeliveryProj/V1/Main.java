public class Main {

    public static void main(String[] args)
    {
        Wrapper first = new Wrapper();
        Wrapper last = new Wrapper();
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

    public static void enqueue(Wrapper head, Wrapper tail, Pizza thispizza)
    {
        if (head.value == null) head.value  = thispizza;
        else tail.value.next = thispizza;
        tail.value = thispizza;
        return;
    }

    public static Pizza dequeue(Wrapper head, Wrapper tail)
    {
        Pizza pizzatodeliver = null;
        if (head.value != null)
        {
            pizzatodeliver = head.value;
            head.value = head.value.next;
        }
        if (head.value == null) tail.value = null;
        return pizzatodeliver;
    }

    public static void deliver(Wrapper head, Wrapper tail)
    {
        Pizza thispizza = dequeue(head,tail);
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

