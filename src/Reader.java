import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Reader extends UnicastRemoteObject implements NewsReader {

	private BulletinBoardNews news;
	private String fileName;
	

	public Reader(BulletinBoardNews n, String file)
			throws RemoteException, FileNotFoundException, UnsupportedEncodingException {
		super();
		this.news = n;
		this.fileName = file;
		
		writeToFile("sSeq\toVal\trID\trNum\n");
		
		
		
	}
	
	

	@Override
	public String read(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	private void writeToFile(String data) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(fileName, "UTF-8");
		writer.write(data);
		writer.close();
	}

}
