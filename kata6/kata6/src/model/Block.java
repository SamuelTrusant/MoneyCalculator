package model;

public class Block implements Figure{
    private final int width;
    private final int height;
    private int posx;
    private int posy;

    public Block(int width, int height, int possx, int possy) {
        this.width = width;
        this.height = height;
        this.posx = possx;
        this.posy = possy;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getPosx() {
        return posx;
    }

    @Override
    public int getPosy() {
        return posy;
    }

    public void updatePosx(int increment){
        this.posx += increment;
    }
    
}
