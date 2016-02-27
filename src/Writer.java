import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Writer extends UnicastRemoteObject implements  NewsWriter {

	private BulletinBoardNews news;
	private String fileName;
	

	public Writer(BulletinBoardNews n, String file)
			throws RemoteException, FileNotFoundException, UnsupportedEncodingException {
		super();
		this.news = n;
		this.fileName = file;	
		writeToFile("sSeq\toVal\twID\n");
		
		
	}
	
	@Override
	public String write(String ID) throws RemoteException {

		return null;
	}

	
	private void writeToFile(String data) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(fileName, "UTF-8");
		writer.write(data);
		writer.close();
	}

}
