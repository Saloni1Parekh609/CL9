// ConversionServer: Design a distributed application which consist of a client server communication using TCP
// technique in Java. Multiple clients can simultaneously connect to the server and send a value in Feet.
// The server returns the value in Metres

import java.net.*;
import java.io.*;

public class temps_tan
{
    // Creating server socket class on port 5004
    ServerSocket ss = new ServerSocket(5004);

    // Creating id to identify multiple clients who have connected
    int id = 0;

    public static void main(String[] args) throws IOException {
        new temps_tan();
    }

    // Construtor to connect clients to the server which is continuously listening
    temps_tan() throws IOException {
        while(true)
        {
            id++;
            ClientThread ct = new ClientThread(ss.accept(), id);
            Thread t = new Thread(ct);
            t.start();
        }
    }
}

// Implementng multithreading using Runnable interface
class ClientThread implements Runnable
{
    Socket cs;
    int id;

    // Setting client id and establishing socket connection
    ClientThread(Socket cs, int id)
    {
        this.cs = cs;
        this.id = id;
    }

    // Overriding the run() which will send and receive messages to and from client
    public void run()
    {
        try
        {
            // Setting readers and wrtiers to communicate
            BufferedReader fromclient = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            PrintWriter toclient = new PrintWriter(cs.getOutputStream(), true);
            toclient.println("Welcome client " + id);
            while(true)
            {
                // Read message from client
                String c = fromclient.readLine();

                // If client sends bye, terminate session for that client
                if(c.contains("bye"))
                    break;
                try {
                    System.out.println("From client: " + id + " Text recieved is:- " + c);
                    System.out.println("To client: " + id + " Text sent is:- " + c);
                    toclient.println("Text from server " + c);

                } catch (Exception e) {
                    // If invalid unit is passed
                    System.out.println("Value " + c + " cannot be converted into metres. Try again..");
                    toclient.println("Value " + c + " cannot be converted into metres. Try again..");
                }
            }
            // Closing connections
            System.out.println("Conversation with client " + id + " has been terminated");
            toclient.close();
            fromclient.close();
            cs.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
