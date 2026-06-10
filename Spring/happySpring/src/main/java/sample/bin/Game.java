package sample.bin;

import java.util.List;

public class Game {
    private List<Player> list;

    public Game(List<Player> playerList) {
    }

    public List<Player> getList() {
        return list;
    }

    public void setList(List<Player> list) {
        this.list = list;
    }

    public void play(){
        for(Player p : list){
            p.play();
        }
    }
}
