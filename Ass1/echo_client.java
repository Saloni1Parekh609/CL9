import java.rmi.*;
import java.util.*;

public class echo_client {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			
			try {
				System.out.print("Enter text to send to server: ");
				String msg = sc.nextLine();
	
				echo_interface obj = (echo_interface)Naming.lookup("rmi://localhost:7002/echoserver");
				obj.echoMessage(msg);
				System.out.println("Message sent to server: " + msg);
				
				if(msg.equals("bye"))
					break;
			}
			catch (Exception e)
			{
				System.out.println("in catch");
				System.out.println(e.getMessage());
			}
			
		}

	}

}
