// ConversionServer: Design a distributed application which consist of a client server communication using TCP
// technique in Java. Multiple clients can simultaneously connect to the server and send a value in Feet.
// The server returns the value in Metres

import java.net.*;
import java.io.*;

public class tempc_tan
{
    public static void main(String[] args) throws IOException, UnknownHostException {
        // Creating socket class from client socket and connecting to server port
        Socket cs = new Socket("localhost", 5004);

        // Setting readers and wrtiers to communicate
        BufferedReader fromclient = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fromserver = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        PrintWriter toserver = new PrintWriter(cs.getOutputStream(), true);

        while(true)
        {
            // Get message from server after conversion and terminate session if there is bye
            String s = fromserver.readLine();
            System.out.println("From server:- " + s);
            if(s.equalsIgnoreCase("bye"))
                break;
            System.out.print("Enter text to send to server:- ");
            String c = fromclient.readLine();
            toserver.println(c);
            if(c.equalsIgnoreCase("bye"))
                break;
        }
        // Close connections
        toserver.close();
        fromserver.close();
        fromclient.close();
        cs.close();
    }
}
