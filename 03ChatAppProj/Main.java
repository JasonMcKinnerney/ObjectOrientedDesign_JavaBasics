public class Main {
    static Server server = new Server();
    public static void main(String args[]) {
        server.Add(new Chatter( "Randy", server));
        server.Add(new Chatter( "Mandy", server));
        server.Add(new Chatter( "Sammy", server));
        server.Add(new Chatter( "Andy", server));
    }
}