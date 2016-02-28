import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

	public static void main(String[] args) throws MalformedURLException {
		System.setSecurityManager(new RMISecurityManager());
		BulletinBoard board = new BulletinBoard();

		try {
			String readersFile = "readers.txt";
			String writersFile = "writers.txt";

			String readerName = "reader";
			String writerName = "writer";

			NewsReader reader = new Reader(board, readersFile);
			Naming.rebind("rmi://localhost/reader", reader);
//			NewsReader readerStub = (NewsReader) UnicastRemoteObject.exportObject(reader, 0);
//
			NewsWriter writer = new Writer(board, writersFile);
			Naming.rebind("rmi://localhost/writer", writer);
//			NewsWriter writerStub = (NewsWriter) UnicastRemoteObject.exportObject(writer, 0);
////
//			Registry registry = LocateRegistry.getRegistry();
//			registry.rebind(readerName, readerStub);
//			registry.rebind(writerName, writerStub);

			System.out.println("Bulletin Board Server is ready....");

		} catch (Exception e) {
			System.err.println("Server failed:");
			e.printStackTrace();
		}

	}

}
