package Strings;

public class TextSubstring {
    public static boolean containsSubstring(String text, String substring) {
        return text.contains(substring);
    }

    public static int countSubstring(String text, String substring) {
        int count = 0;
        int lastIndex = 0;
        while ((lastIndex = text.indexOf(substring, lastIndex)) != -1) {
            count++;
            lastIndex += substring.length();
        }
        return count;
    }
}
