package model;

public class Apple {
    private int width = 5;
    private int height = 5;
    private int posx;
    private int posy;

    public Apple() {
        posx = (int) (Math.random()*570);
        posy = (int) (Math.random()*300);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }
    
    
    
}
