package day09.StringEx;

public class Ex4 {
    public static boolean checkProductNumber(String productNumber){
        if(productNumber == null){
            return false;
        }
        if(productNumber.length() != 6){
            return false;
        }
        for(int i=0; i<2; i++){
            if(!Character.isLetter(productNumber.charAt(i))){
                return false;
            }
        }
        for(int i=2; i<6; i++){
            if(!Character.isDigit(productNumber.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("checkProductNumber(\"te3456\") -> " + checkProductNumber("te3456"));
        System.out.println("checkProductNumber(\"t33456\") -> " + checkProductNumber("t33456"));
        System.out.println("checkProductNumber(\"ar49786\") -> " + checkProductNumber("ar49786"));
        System.out.println("checkProductNumber(\"test56\") -> " + checkProductNumber("test56"));
    }
}
