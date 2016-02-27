import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class Writer extends UnicastRemoteObject implements NewsWriter {

	private BulletinBoard board;
	private String fileName;

	public Writer(BulletinBoard n, String file)
			throws RemoteException, FileNotFoundException, UnsupportedEncodingException {
		super();
		this.board = n;
		this.fileName = file;
		writeToFile("sSeq\toVal\twID\n");

	}

	@Override
	public String write(int ID) throws RemoteException {
		int rSeq = board.incReqNum();
		board.incWritersCount();

		Random r = new Random();
		int Low = 0;
		int High = 10000;
		int sec = r.nextInt(High - Low) + Low;
		String result = "";
		try {
			Thread.sleep(sec);
			board.setObjectVal(ID);
			int sSeq = board.incSerNum();
			board.decWritersCount();
			int oVal = board.getObjectVal();
			result = rSeq + "\t" + sSeq;
			String serverData = sSeq + "\t" + oVal + "\t" + ID;
			writeToFile(serverData);

		} catch (Exception e) {
			// TODO Auto-generated catch block
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
