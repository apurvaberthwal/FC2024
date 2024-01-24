package MScCAII;

public class MScCAIIMarks {
    int SemITotal;
	int SemIITotal;
	
	public MScCAIIMarks(int semITotal, int semIITotal) {
		SemITotal = semITotal;
		SemIITotal = semIITotal;
	}

	
	public String toString() {
		return "MScCAIIMarks [SemITotal=" + SemITotal + ", SemIITotal=" + SemIITotal + "]";
	}
	
	
	public int totalMarksII() {
		int totalMarksII = SemITotal+ SemIITotal;
		return totalMarksII;
	}
}
