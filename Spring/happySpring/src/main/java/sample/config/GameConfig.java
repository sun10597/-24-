package sample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import sample.bin.Dice;
import sample.bin.Game;
import sample.bin.Player;

import java.util.List;

@PropertySource({"classpath:dice.properties"})
public class GameConfig {
    @Value("${face}")
    int face;

    @Bean
    public Dice dice(){
        Dice dice = new Dice();
        dice.setFace(face);
     return dice;
    }

    @Bean
    public Player kim(){
        Player player = new Player();
        player.setName("kim");
        player.setDice(dice());
        return player;
    }

    @Bean
    public Player kim(Dice dice){
        Player player = new Player();
        player.setName("kim");
        player.setDice(dice);
        return player;
    }

    @Bean
    public Game game(List<Player> playerList){
//        Game game = new Game();
//        game.setList(playerList);
//        return game;
        return new Game(playerList);
    }
}

