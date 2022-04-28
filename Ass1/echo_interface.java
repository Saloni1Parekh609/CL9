import java.rmi.*;

public interface echo_interface extends Remote{
	
	public void echoMessage(String msg) throws RemoteException;

}
