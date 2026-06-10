package sample.bin;

import java.util.Random;

public class Dice {
    private int number;
    private int face;


    public int roll() {
        Random random = new Random();
        this.number = random.nextInt(face) + 1;
        return this.number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }
}
