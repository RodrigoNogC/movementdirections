import levels.LevelTest;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LevelTest levelTest = new LevelTest();
                levelTest.setVisible(true);
            }
        });

    }
 }