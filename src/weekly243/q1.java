package weekly243;

public class q1 {
	public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return convert(firstWord) + convert(secondWord) == convert(targetWord);
    }
    public int convert(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<word.length(); i++) {
            int t = word.charAt(i)-'a';
            sb.append(t);
        }
        return Integer.parseInt(sb.toString());
    }
}
