package MScCAI;

public class MScCAIMarks {

    int SemITotal;
	int SemIITotal;
	
	
	
	public MScCAIMarks(int semITotal, int semIITotal) {
		SemITotal = semITotal;
		SemIITotal = semIITotal;
	}


    public String toString() {
		return "MScCAIMarks [SemITotal=" + SemITotal + ", SemIITotal=" + SemIITotal + "]";
	}
	
	
	public int totalMarksI() {
		int totalMarksI = SemITotal+ SemIITotal;
		return totalMarksI;
	}
	
}


