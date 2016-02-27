import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class Reader extends UnicastRemoteObject implements NewsReader {

	private BulletinBoard board;
	private String fileName;

	public Reader(BulletinBoard n, String file)
			throws RemoteException, FileNotFoundException, UnsupportedEncodingException {
		super();
		this.board = n;
		this.fileName = file;

		writeToFile("sSeq\toVal\trID\trNum\n");

	}

	@Override
	public String read(int ID) throws RemoteException {
		int rSeq = board.incReqNum();
		int oVal = board.getObjectVal();
		int rNum = board.incReadersCount();
		Random r = new Random();
		int Low = 0;
		int High = 10000;
		int sec = r.nextInt(High-Low) + Low;
		String result = "";
		
		try {
			Thread.sleep(sec);
			int sSeq = board.incSerNum();
			board.decReadersCount();
			
			
			String serverData = sSeq + "\t" + oVal + "\t"+ ID +rNum;
			result = rSeq + "\t" + sSeq + "\t" +oVal;
			writeToFile(serverData);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

	private void writeToFile(String data) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(fileName, "UTF-8");
		writer.write(data);
		writer.close();
	}

}
