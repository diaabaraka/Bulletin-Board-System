
public class BulletinBoard {
	private int objectVal;
	private int reqNum;
	private int serNum;

	private int readersCount;
	private int writersCount;

	public BulletinBoard() {
		this.objectVal = -1;
		this.reqNum = 0;
		this.readersCount = 0;
		
	}

	public int incObjectVal() {
		
		this.objectVal++;
		return this.objectVal;
	}

	public int incReqNum() {
		this.reqNum++;
		return reqNum;
	}
	public int incSerNum() {
		this.serNum++;
		return serNum;
	}

	public int incReadersCount() {
		this.readersCount++;
		return readersCount;
	}
	public int incWritersCount() {
		this.writersCount++;
		return writersCount;
	}
	
	public int decReadersCount() {
		this.readersCount--;
		return readersCount;
	}
	public void setObjectVal(int objectVal) {
		this.objectVal = objectVal;
	}
	public void updateReadersCount(int val) {
		this.readersCount = readersCount + val;
	}

	public int decWritersCount() {
		this.writersCount --;
		return writersCount;
	}

	public int getObjectVal() {
		return objectVal;
	}

	public int getSeqNum() {
		return reqNum;
	}

	public int getReadersCount() {
		return readersCount;
	}

}
