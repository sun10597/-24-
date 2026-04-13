package day09.StringEx;



public class Ex1 {

    public static int sumOfDigits(String str){
        int sum=0;
        if(str == null){
            return 0;
        }
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                sum += Character.getNumericValue(ch);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        String a = "q1w2e3r4";
        System.out.println("sumOfDigits(" + a + ") -> " + sumOfDigits(a));
    }
}

