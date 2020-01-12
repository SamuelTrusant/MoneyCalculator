package UI;

import Model.Image;
import java.awt.Graphics;
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
        g.drawImage(imageOf(current),0,0,null);
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
