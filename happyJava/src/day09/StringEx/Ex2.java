package day09.StringEx;

public class Ex2 {
    public static String replaceAllWords(String original, String target, String replacement){
        if(original == null || target == null || replacement == null){
            return original;
        }
        return original.replace(target, replacement);
    }

    public static void main(String[] args) {
        String result = replaceAllWords("I like cat. Cat is cute.", "cat", "dog");
        System.out.println(result);
    }
}
