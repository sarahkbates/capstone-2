package flappybird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class FlappyBird extends Birdies implements ActionListener, MouseListener, KeyListener{
    //implementing interfaces to allow mouse click/space bar functionality

    public static FlappyBird flappyBird;

    public final int WIDTH = 1200;
    public static final int HEIGHT = 800; //JFrame size

    public Renderer renderer;

    public Rectangle bird;

    public ArrayList<Rectangle> columns; //continuous creation of rectangles (pipes)

    public int ticks, yMotion, score;

    public GameState gameState = GameState.CLICKTOSTART;

    public Random rand; //random placement of pipes

    Timer timer = new Timer(20, this);

    Timer countdownTimer = new Timer(1000, this);

    Timer badKeyTimer = new Timer(500, this);
    static boolean wrongKey;

    public FlappyBird() {
        JFrame jframe = new JFrame();


        renderer = new Renderer();
        rand = new Random();

        jframe.add(renderer);
        jframe.setTitle("Flappy Bird");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //game stops running when JFrame is closed
        jframe.setSize(WIDTH, HEIGHT);
        jframe.addMouseListener(this);
        jframe.addKeyListener(this);
        jframe.setResizable(false); //graphics do not change when you resize
        jframe.setVisible(true);

        bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
        columns = new ArrayList<Rectangle>();

        addColumn(true); //four columns created at a time
        addColumn(true);
        addColumn(true);
        addColumn(true);

        timer.start();
    }

    public void addColumn(boolean start) {
        int space = 300;
        int width = 100;
        int height = 50 + rand.nextInt(300); //height of pipes is random, so gap between changes every time

        if (start) {
            //bottom and top pipes rendering as game plays
            columns.add(new Rectangle(WIDTH + width + columns.size() * 300, HEIGHT - height - 120, width, height));
            columns.add(new Rectangle(WIDTH + width + (columns.size() - 1) * 300, 0, width, HEIGHT - height - space));
        } else {
            //create columns even when game has not "started"
            columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, HEIGHT - height - 120, width, height));
            columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, width, HEIGHT - height - space));
        }
    }

    public void paintColumn(Graphics g, Rectangle column) {
        g.setColor(Color.green.darker());
        g.fillRect(column.x, column.y, column.width, column.height);
    }

    public void handleInput() {
        if (gameState == GameState.GAMEOVER) {
            //restart once Game Over happens
            bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
            columns.clear();
            yMotion = 0;
            score = 0;

            addColumn(true);
            addColumn(true);
            addColumn(true);
            addColumn(true);

            gameState = GameState.CLICKTOSTART;
        } else if (gameState == GameState.STARTED) {
            //resets bird placement once game is no longer over
            if (yMotion > 0) {
                yMotion = 0;
            }

            yMotion -= 10;
        } else if (gameState == GameState.CLICKTOSTART) {
            gameState = GameState.COUNT3;
            countdownTimer.start();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //how fast bird is moving, and how much y increases with each click
        int speed = 10;

        ticks++;

        if (e.getSource() == countdownTimer) {
            switch (gameState) {
                case COUNT3:
                    gameState = GameState.COUNT2;
                    break;
                case COUNT2:
                    gameState = GameState.COUNT1;
                    break;
                case COUNT1:
                    gameState = GameState.COUNTGO;
                    break;
                case COUNTGO:
                    gameState = GameState.STARTED;
                    countdownTimer.stop();
                    break;
            }

        } else if (e.getSource() == badKeyTimer) {

            wrongKey = false;
            badKeyTimer.stop();


        }
        //just the regular timer, because it's not the other two
        else if (gameState == GameState.STARTED) {

            //columns moving with game
            columns.forEach(column -> {
                column.x -= speed; });


            if (ticks % 2 == 0 && yMotion < 15) {
                yMotion += 2;
            }

            var badColumns = (columns.stream().filter(column -> column.x + column.width < 0).toArray(Rectangle[] :: new));
            for (Rectangle column : badColumns){
                       columns.remove(column);
                    }
            if (columns.size() < 8){
                addColumn(false);
            }

            bird.y += yMotion;

            for (Rectangle column : columns) {
                //need the column.y == 0, so that you only get 1 point for passing pipes (otherwise you get 2 points because there are technically 2 pipes your passing)
                if (column.y == 0 && bird.x + bird.width / 2 > column.x + column.width / 2 - 10 && bird.x + bird.width / 2 < column.x + column.width / 2 + 10) {
                    score++;
                }

                if (column.intersects(bird)) {
                    //bird can't hit pipes or game over
                    gameState = GameState.GAMEOVER;

                    if (bird.x <= column.x) {
                        bird.x = column.x - bird.width;

                    } else {
                        //bird  can't go through pipe
                        if (column.y != 0) {
                            bird.y = column.y - bird.height;
                        } else if (bird.y < column.height) {
                            bird.y = column.height;
                        }
                    }
                }
            }

            if (bird.y > HEIGHT - 120 || bird.y < 0) {
                gameState = GameState.GAMEOVER;
            }

            if (bird.y + yMotion >= HEIGHT - 120) {
                bird.y = HEIGHT - 120 - bird.height;
                gameState = GameState.GAMEOVER;
            }
        }

        renderer.repaint();
    }


    public void repaint(Graphics g) {
        //sky
        g.setColor(Color.cyan);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        //ground
        g.setColor(Color.orange);
        g.fillRect(0, HEIGHT - 120, WIDTH, 120);

        //grass
        g.setColor(Color.green);
        g.fillRect(0, HEIGHT - 120, WIDTH, 20);

        //bird
        g.setColor(Color.red);
        g.fillRect(bird.x, bird.y, bird.width, bird.height);

        for (Rectangle column : columns) {
            paintColumn(g, column);
        }

        g.setColor(Color.white);
        g.setFont(new Font("Arial", 1, 100));

        switch (gameState) {

            case CLICKTOSTART:
                g.drawString("Click to start!", 325, HEIGHT / 2 - 50);
                break;


            case GAMEOVER:
                g.drawString("Game Over!", 350, HEIGHT / 2 - 50);
                break;

            case STARTED:
                g.drawString(String.valueOf(score), WIDTH / 2 - 25, 100);
                break;

            case COUNT3:
                g.drawString("3", 600, HEIGHT / 2 - 50);
                break;

            case COUNT2:
                g.drawString("2", 600, HEIGHT / 2 - 50);
                break;

            case COUNT1:
                g.drawString("1", 600, HEIGHT / 2 - 50);
                break;

            case COUNTGO:
                g.drawString("GO!", 575, HEIGHT / 2 - 50);
                break;

        }
        if (wrongKey) {
            g.drawString("Press SpaceBar or Click!", 0, 150);
        }
    }


    //calling game to run
    public static void main(String[] args) {
        flappyBird = new FlappyBird();
    }

    //click and bird moves
    @Override
    public void mouseClicked(MouseEvent e) {
        handleInput();

    }

    //hit spacebar and bird moves
    @Override
    public void keyReleased(KeyEvent e) {

    }

    //methods required to implement due to interface
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == ' ') {
            handleInput();
        } else {
            wrongKey = true;
            badKeyTimer.start();

        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

}