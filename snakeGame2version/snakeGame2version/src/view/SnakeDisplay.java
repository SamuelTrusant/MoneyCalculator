package view;

import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Apple;
import model.Snake;

public class SnakeDisplay extends JPanel {
    private Snake snake;
    private Apple apple;
    
    
    public SnakeDisplay(Snake snake){
        this.snake = snake;
        this.apple = new Apple((int) (Math.random() * this.getWidth()), (int) (Math.random() * this.getHeight()),5,5);
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
        boolean is = isInside(apple.getPosx(),apple.getPosy(),snake.getBodyx(),snake.getBodyy(),0);
        if (is){
            this.apple = new Apple((int) (Math.random() * this.getWidth()), (int) (Math.random() * this.getHeight()),5,5);
            snake.increaseLength();
        }
        return is;
    }

    private boolean isInside(int ax, int ay, int[] sx, int[] sy, int o){
        int limit = 0;
        
        if(o==0){
            limit = sx.length;
        } else {
            limit = sx.length-1;
        }
        for (int i = 0; i < limit; i++) {
            if (ax >= sx[i] - snake.getSegmentWidth()/2 && ax <= sx[i] + snake.getSegmentWidth()/2){
                if(ay >= sy[i] - snake.getSegmentHeight()/2 && ay <= sy[i] + snake.getSegmentHeight()/2) return true;
            }
        }
        return false;
    }
    
    public boolean isOutOfField(){
        int headx = snake.getHeadx();
        int heady = snake.getHeady();
        if(headx - (snake.getSegmentWidth()/2) < 0) return true;
        if(headx + (snake.getSegmentWidth()/2) > this.getWidth()) return true;
        if(heady - (snake.getSegmentHeight()/2) < 0) return true;
        if(heady + (snake.getSegmentHeight()/2) > this.getHeight()) return true;
        return false;
    }
    
    public boolean biteItself(){
        return isInside(snake.getHeadx(),snake.getHeady(),snake.getBodyx(),snake.getBodyy(),1);
    }
    
    public void die(){
        JOptionPane.showMessageDialog(null, "you lose");
        this.snake = new Snake(snake.getSegmentWidth(),snake.getSegmentHeight(),4,this.getWidth()/2,this.getHeight()/2);
        this.apple = new Apple((int) (Math.random() * this.getWidth()), (int) (Math.random() * this.getHeight()),apple.getWidth(),apple.getHeight());
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int[] x = snake.getBodyx();
        int[] y = snake.getBodyy();
        
        for (int i = 0; i < snake.getLength(); i++) {
            g.fillRect(x[i]-snake.getSegmentWidth()/2, y[i]-snake.getSegmentHeight()/2, snake.getSegmentWidth(), snake.getSegmentHeight());
            g.fillRect(apple.getPosx()-apple.getWidth()/2, apple.getPosy()-apple.getWidth()/2, apple.getWidth(), apple.getHeight()); 
        }
    }
    
    private TimerTask task() {
        return new TimerTask() {
            @Override
            public void run() {
                snake.updatePos();
                show();
                if(isOutOfField() || biteItself()){
                    die();
                }
                boolean s = snakeBiteApple();
                System.out.println(s);
            }
        };
    }        
}
