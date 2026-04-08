package day06;

import java.util.Arrays;

public class Lotto {
    int[] num = new int[6];

    public void randomNum(){
        for(int i=0; i<num.length; i++){
            num[i] = (int)((Math.random()*45)+1);

            for(int j=0; j<i; j++){
                if(num[i] == num[j]){
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(num);
    }

    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        lotto.randomNum();
        System.out.println(Arrays.toString(lotto.num));
    }
}
