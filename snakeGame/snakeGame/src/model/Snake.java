package model;


public class Snake {
    private int width;
    private int height;
    private int length = 4;
    private int[] posx = new int[length];
    private int[] posy = new int[length];
    private int direction = 0; //0 = Right; 1 = up; 2 = left; 3 = down

    public Snake(int width, int height, int posx, int posy) {
        this.width = width;
        this.height = height;
        this.posx[0] = posx;
        this.posy[0] = posy;
        for (int i = 1; i < length; i++) {
            this.posx[i] = this.posx[i-1] + 5;
            this.posy[i] = this.posy[i-1] + 5;
        }
    }
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getDirection() {
        return direction;
    }
    
    public int[] getPosx() {
        return posx;
    }

    public int[] getPosy() {
        return posy;
    }

    public void updatePos(){
        for (int i = 0; i < length-1; i++) {
            posx[i] = posx[i+1];
            posy[i] = posy[i+1];
        }
        
        switch(direction) {
            case 0:
                if (posx[length-1] <= 570) posx[length-1] += 5;
                break;
            case 1:
                if (posy[length-1] > 0) posy[length-1] -= 5;
                break;
            case 2:
                if (posx[length-1] > 0) posx[length-1] -= 5;
                break;
            case 3:
                if (posy[length-1] <= 300) posy[length-1] += 5;
                break;
        }
    }
    
    public void changeDirection(int direction){
        switch(direction){
            case 0:
                if(this.direction != 2) this.direction = direction;
                break;
            case 1:
                if(this.direction != 3) this.direction = direction;
                break;
            case 2:
                if(this.direction != 0) this.direction = direction;
                break;   
            case 3:
                if(this.direction != 1) this.direction = direction;
                break;
        }
    }

    public void increaseLength() {
        length+=4;
        int[] auxx = new int[length];
        int[] auxy = new int[length];
        
        for (int i = 0; i < posx.length; i++) {
            auxx[i] = posx[i];
            auxy[i] = posy[i];
        }
        for (int j = posx.length; j < auxx.length; j++) {
            auxx[j] = auxx[j-1];
            auxy[j] = auxy[j-1];
        }
        posx = auxx;
        posy = auxy;
    }

}
