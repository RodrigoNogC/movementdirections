package Codes;

import characters.Player;
import levels.LevelTest;

import javax.swing.*;

public class codLavelTest {

    public static void main(String[] args){

        SwingUtilities.invokeLater(() ->{
            LevelTest levelTest = new LevelTest();
            Player player = new Player();
            levelTest.add(player);
            levelTest.setVisible(true);
        });

    }
}
