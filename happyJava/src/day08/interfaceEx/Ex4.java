package day08.interfaceEx;

interface Attackable{
    void attack();
}
class SordAttack implements  Attackable{
    @Override
    public void attack() {
        System.out.println("칼로 공격합니다!");
    }
}
class BowAttack implements Attackable{
    @Override
    public void attack() {
        System.out.println("활로 공격합니다!");
    }
}
class Character{
    private Attackable attackStrategy;

    public void setAttackStrategy(Attackable Strategy) {
        this.attackStrategy = Strategy;
    }
    public void perfomAttack(){
//        if (attackStrategy == null){
//            System.out.println("공격 전략을 선택해주세요");
//            return;
//        }
        attackStrategy.attack();
    }
}
public class Ex4 {
    public static void main(String[] args) {
        Character character = new Character();
//        character.perfomAttack();
        character.setAttackStrategy(new SordAttack());
        character.perfomAttack();
        character.setAttackStrategy(new BowAttack());
        character.perfomAttack();
    }
}
