package day09.StringEx;

public class Ex5 {
    public static int spaceCount(String str) {
        int count = 0;
        if (str == null) {
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public static int alphaCount(String str) {
        int count = 0;
        if (str == null) {
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "test tset ts ttt";
        System.out.println("문자열: \"" + str + "\"");
        System.out.println("공백 개수: " + spaceCount(str));
        System.out.println("알파벳 개수: " + alphaCount(str));
    }
}