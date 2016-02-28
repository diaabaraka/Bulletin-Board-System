import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

		writeToFile("sSeq\toVal\trID\trNum", false);

	}

	@Override
	public String read(int ID) throws RemoteException {
		
		int rSeq = 0;
		int rNum = 0;
		int sSeq = 0;
		synchronized (this) {
			rSeq = board.incReqNum();
			
		}
		rNum = updateReaders(1);
		String result = "";

		try {
			sleep();
		} catch (Exception e) {

			e.printStackTrace();
		}
		int oVal = board.getObjectVal();

		synchronized (this) {
			sSeq = board.incSerNum();
		}
		updateReaders(-1);

		String serverData = sSeq + "\t" + oVal + "\t" + ID + "\t" + rNum;
		result = rSeq + "\t" + sSeq + "\t" + oVal;

		synchronized (this) {
			writeToFile(serverData, true);
		}

		return result;
	}
	private synchronized int updateReaders(int val ) {
		board.updateReadersCount(val);
		return board.getReadersCount();
	}

	private void writeToFile(String data, boolean toAppend) {
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, toAppend)));
			out.println(data);
			out.close();
		} catch (IOException e) {
			// exception handling left as an exercise for the reader
		}
	}

	private void sleep() throws InterruptedException {
		Random r = new Random();
		int Low = 0;
		int High = 10000;
		int secToSleep = r.nextInt(High - Low) + Low;

		Thread.sleep(secToSleep);

	}

}
