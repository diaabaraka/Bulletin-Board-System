import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NewsReader extends Remote{
	public String read(String ID) throws RemoteException;

}
