
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
		int val = this.objectVal + 1;
		return val;
	}

	public int incReqNum() {
		int val = this.reqNum + 1;
		return val;
	}
	public int incSerNum() {
		int val = this.serNum + 1;
		return val;
	}

	public int incReadersCount() {
		int val = this.readersCount + 1;
		return val;
	}
	public int incWritersCount() {
		int val = this.writersCount + 1;
		return val;
	}
	public int decReadersCount() {
		int val = this.readersCount - 1;
		return val;
	}
	public void setObjectVal(int objectVal) {
		this.objectVal = objectVal;
	}

	public int decWritersCount() {
		int val = this.writersCount - 1;
		return val;
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
