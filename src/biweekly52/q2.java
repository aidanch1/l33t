package biweekly52;

public class q2 {
	public int[] memLeak(int memory1, int memory2) {
        int sec = 1;
        while (memory1-sec >= 0 || memory2-sec >= 0) {
        	if (memory1 >= memory2) {
        		memory1 -= sec;
        	}
        	else {
        		memory2 -= sec;
        	}
        	sec++;
        }
        return new int[] {sec, memory1, memory2};
    }
}
