package view;

import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;
import model.Apple;
import model.Snake;

public class SnakeDisplay extends JPanel {
    private Snake snake;
    private Apple apple;
    
    public SnakeDisplay(Snake snake){
        this.snake = snake;
        this.apple = new Apple();
        Timer timer = new Timer();
        timer.schedule(task(), 0, 100);
    }

    public void show() {
        this.repaint();
    }
    
    public Snake snake(){
        return this.snake;
    }
    
    public boolean snakeBiteApple(){
        return isInside(apple.getPosx(),apple.getPosy(),snake.getPosx(),snake.getPosy());
    }

    private boolean isInside(int ax, int ay, int[] sx, int[] sy){
        for (int i = 0; i < sx.length; i++) {
            if (ax >= sx[i] - snake.getWidth()/2 && ax <= sx[i] + snake.getWidth()/2){
                if(ay >= sy[i] - snake.getHeight()/2 && ay <= sy[i] + snake.getHeight()/2) return true;
            }
        }
        return false;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int[] x = snake.getPosx();
        int[] y = snake.getPosy();
        
        for (int i = 0; i < snake.getLength(); i++) {
            g.fillRect(x[i], y[i], snake.getWidth(), snake.getHeight());
            g.fillRect(apple.getPosx(), apple.getPosy(), apple.getWidth(), apple.getHeight()); 
        }
    }
    
    private TimerTask task() {
        return new TimerTask() {
            @Override
            public void run() {
                snake.updatePos();
                boolean s = snakeBiteApple();
                System.out.println(s);
                if(s){
                    apple = new Apple();
                    snake.increaseLength();
                }
                show();
            }
        };
    }        
}
