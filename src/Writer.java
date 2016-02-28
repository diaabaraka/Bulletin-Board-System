import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
		writeToFile("sSeq\toVal\twID", false);

	}

	@Override
	public String write(int ID) throws RemoteException {
		int rSeq = 0;
		synchronized (this) {
			 rSeq = board.incReqNum();
		}
		String result = "";
		synchronized (this) {

			board.incWritersCount();
			

			try {
				sleep();
				board.setObjectVal(ID);
				int sSeq = board.incSerNum();
				board.decWritersCount();
				int oVal = board.getObjectVal();
				result = rSeq + "\t" + sSeq;
				String serverData = sSeq + "\t" + oVal + "\t" + ID;
				writeToFile(serverData, true);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	private void writeToFile(String data, boolean toAppend) {
		try {
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, toAppend)));
		    out.println(data);
		    out.close();
		} catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
	}
	private   void sleep() throws InterruptedException {
		Random r = new Random();
		int Low = 0;
		int High = 10000;
		int secToSleep = r.nextInt(High - Low) + Low;

		Thread.sleep(secToSleep);

	}



}
