package weekly245;

public class q3 {
	public boolean mergeTriplets(int[][] triplets, int[] target) {
        //find up to 3 triplets where max of each a b c = target
        boolean a = false;
        boolean b = false;
        boolean c = false;
        for (int[] i:triplets) {
            if (i[0] == target[0] && i[1] <= target[1] && i[2] <= target[2]) {
                a = true;
            }
            if (i[1] == target[1] && i[0] <= target[0] && i[2] <= target[2]) {
                b = true;
            }
            if (i[2] == target[2] && i[0] <= target[0] && i[1] <= target[1]) {
                c = true;
            }
        }
        return a && b && c;
    }
}
