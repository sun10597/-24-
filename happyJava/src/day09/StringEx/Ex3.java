package day09.StringEx;

public class Ex3 {
    public static int countChar(String str, char c){
        int count = 0;
        if(str == null){
            return 0;
        }
        for(int i=0; i<str.length(); i++){
          if(str.charAt(i) == c){
              count++;
          }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("countChar(\"banana\", 'a') -> " + countChar("banana", 'a'));
        System.out.println("countChar(\"hello\", 'l') -> " + countChar("hello", 'l'));
    }
}
