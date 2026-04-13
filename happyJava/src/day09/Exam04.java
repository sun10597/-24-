package day09;

class CaramiClass{
    private int i;

    public CaramiClass(int i){
        this.i = i;
    }

//    @Override
//    public boolean equals(Object obj){
//        if(this == obj) return true;
//        if(obj == null) return false;
//    }
//    return false;
}
public class Exam04 {
    public static void main(String[] args) {
        CaramiClass caramiClass1 = new CaramiClass(10);
        CaramiClass caramiClass2 = new CaramiClass(10);
    }
}
