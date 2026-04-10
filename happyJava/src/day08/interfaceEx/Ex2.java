package day08.interfaceEx;

interface Movable{
    void move(int x, int y);
}

interface Drawable{
    void draw();
}

class GameObject implements Movable, Drawable{
    private int x, y;
    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y= y;
    }
    @Override
    public void draw() {
        System.out.printf("현재 좌표를 객체가 (%d, %d)에 그렸습니다.\n", x, y);
    }
}
public class Ex2 {
    public static void main(String[] args) {
//        Movable movable = new GameObject();
//        movable.move(3,4);
//        Drawable drawable = new GameObject();
//        drawable.draw();
        GameObject gameObject = new GameObject();
        gameObject.move(4,5);
        gameObject.draw();
    }
}
