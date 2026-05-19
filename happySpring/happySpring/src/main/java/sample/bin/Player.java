package sample.bin;

public class Player {
    private  String name;
    private Dice dice;

    public Player(){}

    public void play(){
        System.out.println(name + "는 주사위를 던져서" + dice.roll() + "이(가) 나왔습니다.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }
}
