package view;

import java.awt.Graphics;
import javax.swing.JPanel;
import model.Block;

public class BlockDisplay extends JPanel {
    private Block block;
    
    public BlockDisplay(Block block){
        this.block = block;
    }

    public void show() {
        this.repaint();
    }
    
    public Block block(){
        return this.block;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(block.getPosx(), block.getPosy(), block.getWidth(), block.getHeight());
    }
    
}
