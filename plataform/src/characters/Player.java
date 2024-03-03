package characters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player extends JPanel {

    private JPanel characterPanel;
    private int characterX;
    private int characterY;
    private int characterHeight;
    private int characterWidth;
    private int moveSpeed;
    private Timer timerSides;
    private Timer timerUpDown;
    private boolean isMovingLeft;
    private boolean isMovingUp;

    public Player() {
        characterX = 180;
        characterY = 120;
        characterHeight = 30;
        characterWidth = 20;
        moveSpeed = 7;

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_A){
                    isMovingLeft = true;
                    movingLeft();
                } else if (keyCode == KeyEvent.VK_D) {
                    isMovingLeft = false;
                    movingRight();
                } else if (keyCode == KeyEvent.VK_W) {
                    isMovingUp = true;
                    movingUp();
                } else if (keyCode == KeyEvent.VK_S) {
                    isMovingUp = false;
                    movingDown();
                }
            }

            @Override
            public void keyReleased(KeyEvent e){
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_D){
                    stopMovingSides();
                }
                if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_S){
                    stopMovingUpDown();
                }
            }
        });

        setFocusable(true); // Permite que o JFrame receba o foco para capturar eventos de teclado
        requestFocus();

        timerSides = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updatePositionSides();
            }
        });

        timerUpDown = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updatePositionUpDown();
            }
        });
    }



    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        // Define a cor do retângulo
        graphics.setColor(Color.RED);
        graphics.fillRect(characterX, characterY, characterWidth, characterHeight);
    }

    private void movingLeft(){
        timerSides.start();
    }

    private void movingRight(){
        timerSides.start();
    }

    private void movingUp(){
        timerUpDown.start();
    }

    private void movingDown(){
        timerUpDown.start();
    }

    private void stopMovingSides(){
        timerSides.stop();
    }

    private void stopMovingUpDown(){
        timerUpDown.stop();
    }

    private void updatePositionSides() {
        if (isMovingLeft && characterX > 0){
            characterX -= moveSpeed;
        } else if (!isMovingLeft && characterX < 800 - characterWidth) {
            characterX += moveSpeed;
        }
        repaint();
    }

    private void updatePositionUpDown(){
        if (isMovingUp && characterY > 0){
            characterY -= moveSpeed;
        } else if (!isMovingUp && characterY < 600 - characterHeight) {
            characterY += moveSpeed;
        }
        repaint();
    }

}
