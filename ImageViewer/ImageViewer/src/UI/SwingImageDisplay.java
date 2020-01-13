package UI;

import Model.Image;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private Image current;
    
    @Override
    public Image Current() {
        return this.current;
    }

    @Override
    public void show(Image image) {
        this.current = image;
        this.repaint();
    }
    
    @Override
    public void paint(Graphics g){
        if (current == null) return;
        BufferedImage bufferedCurrent = imageOf(current);
        Rectangle size = this.getBounds();
        int posx = size.width/2 - bufferedCurrent.getWidth()/2;
        int posy = size.height/2 - bufferedCurrent.getHeight()/2;
        System.out.println("dfdf" + this.getBounds());
        System.out.println(posx + " , " + posy);
        g.drawImage(bufferedCurrent,posx,posy,null);
    };
            
    private BufferedImage imageOf(Image image) {
        try {
            return ImageIO.read(image.stream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    };    
}
