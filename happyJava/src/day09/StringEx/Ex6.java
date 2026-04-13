package day09.StringEx;

public class Ex6 {
    public static String reverseChange(String str){
        if(str == null){
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("abc -> " + reverseChange("abc"));
        System.out.println("Hello -> " + reverseChange("Hello"));
    }
}
