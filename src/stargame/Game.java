package stargame;

import stargame.ships.BattleShip;
import stargame.ships.LightFighter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Game {
    public static void main(String[] args) {
        FighterGroup fleet1 = new FighterGroup() ;
        FighterGroup fleet2 = new FighterGroup() ;

        fleet1.addFighter(new LightFighter(),50000);

        fleet2.addFighter(new LightFighter(),300);
        fleet2.addFighter(new BattleShip(),10);
        FighterGroup.DoFight(fleet1,fleet2);
        System.out.println(fleet1);
        System.out.println(fleet2);

    }
}
