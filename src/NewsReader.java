import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NewsReader extends Remote{
	public String read(int ID) throws RemoteException;

}
