import java.net.*;
import java.io.*;

public class echoserver_udp_server {
	public static void main(String[] args) throws IOException
    {
        // Create a socket to listen at port 1234
        DatagramSocket ds = new DatagramSocket(1234);
        byte[] receive = new byte[65535];
  
        DatagramPacket DpReceive = null;
        while (true)
        {
        	System.out.println("Waiting for client to send message...");
  
            // create a DatgramPacket to receive the data.
            DpReceive = new DatagramPacket(receive, receive.length);
  
            // Receive the data in byte buffer.
            ds.receive(DpReceive);
  
            System.out.println("Client:-" + data(receive));
  
            // Exit the server if the client sends "bye"
            if (data(receive).toString().equals("bye"))
            {
                System.out.println("Client sent bye.....EXITING");
                break;
            }
  
            // Clear the buffer after every message.
            receive = new byte[65535];
        }
        
        ds.close();
        
    }
        
    public static StringBuilder data(byte[] a)
    {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }

}
