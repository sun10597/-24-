package day11;

class ScoreException extends RuntimeException{
    ScoreException(){
        super("점수는 0-100까지만 입력가능");
    }
}

class StudentMgr{
    public void inputScore(int score)throws RuntimeException{
        if(score < 0 || score > 100){
//            throw new RuntimeException(
//                    "점수는 0-100까지만 입력가능 score: "+ score
            throw new ScoreException();
//            );
        }
    }
}
public class Exception4 {
    public static void main(String[] args) {
        StudentMgr studentMgr = new StudentMgr();
        studentMgr.inputScore(100);
        studentMgr.inputScore(-20);
    }
}
