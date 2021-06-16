package weekly245;

public class q1 {
	public boolean makeEqual(String[] words) {
        int[] charCount = new int[26];
        for (String s:words) {
            char[] c = s.toCharArray();
            for (char c1 : c) {
                int a = c1 - 'a';
                charCount[a]++;
            }
        }
        for (int i=0; i<26; i++) {
            if (charCount[i] % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
