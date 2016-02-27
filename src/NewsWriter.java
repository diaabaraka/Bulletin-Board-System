import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NewsWriter extends Remote{
	public String write(String ID)throws RemoteException;
}
