package day07;

public class Test {
    int result =0;
    int test(){
        try{
            return 3;
        }
        finally{
            result = 2;
        }
    }
    public static void main(String[] args){
        Test p = new Test();
        System.out.print(p.test());
    }
}
