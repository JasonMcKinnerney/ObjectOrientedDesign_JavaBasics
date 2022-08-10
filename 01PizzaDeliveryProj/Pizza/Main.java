public class Main {

    public static void main(String[] args)
    {
        Queue q1 = new Queue();
        
        q1.enqueue(new Pizza("pepperoni", "1234 Bobcat Trail"));
        q1.enqueue(new Pizza("sausage", "2345 University Drive"));
        q1.deliver();
        q1.enqueue(new Pizza("extra cheese", "3456 Rickster Road"));
        q1.enqueue(new Pizza("everything", "4567 King Court"));
        q1.enqueue(new Pizza("coffee beans", "5678 Java Circle"));
        q1.deliver();
        q1.deliver();
        q1.deliver();
        q1.deliver();
        q1.deliver();
    }
}


