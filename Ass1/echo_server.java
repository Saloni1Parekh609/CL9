import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class echo_server  {
	
	
	public static void main(String argv[]) {
		
		try {
			echo_interface obj = new echo_impl();
			LocateRegistry.createRegistry(7002);			
			Naming.rebind("rmi://localhost:7002/echoserver", obj);
			System.out.println("Server object successfully bound to RMI Registry");			
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
