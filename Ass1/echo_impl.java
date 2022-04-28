import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class echo_impl extends UnicastRemoteObject implements echo_interface{
	
	public echo_impl() throws RemoteException { super(); };
	
	public void echoMessage(String msg) throws RemoteException {
		
		System.out.println("Server: Message recieved > " + msg);
		
	}

}
