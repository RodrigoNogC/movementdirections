package levels;

import characters.Player;

import javax.swing.*;
import java.awt.*;

public class LevelTest  extends JFrame {

    private JPanel gamePanel;


    public LevelTest() {

        setTitle("level test");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel = new JPanel();
        gamePanel.setLayout(null); //Usamos um Layout nulo para porder controlar o personagem manualmente
        add(gamePanel);


    }

}
