
public class BulletinBoardNews {
	private int objectVal;
	private int seqNum;
	private int readersCount;
	public BulletinBoardNews() {
		this.objectVal = -1;
		this.seqNum = 0;
		this.readersCount = 0;
	}
	public void setObjectVal(int objectVal) {
		this.objectVal = objectVal;
	}

	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}

	public void setReadersCount(int readersCount) {
		this.readersCount = readersCount;
	}

	public int getObjectVal() {
		return objectVal;
	}

	public int getSeqNum() {
		return seqNum;
	}

	public int getReadersCount() {
		return readersCount;
	}

}
