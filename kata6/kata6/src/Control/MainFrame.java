package Control;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Block;
import view.BlockDisplay;

public class MainFrame extends JFrame {
    private BlockDisplay blockDisplay;
    
    public MainFrame() {
        setTitle("block");
        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Block block = new Block(60,40, 500/2 -60, 300/2 -40);
        blockDisplay = new BlockDisplay(block);
        this.getContentPane().add(blockDisplay);
        this.getContentPane().add(toolBar(),BorderLayout.SOUTH);
    }
    
    public JPanel toolBar(){
        JPanel panel = new JPanel();
        panel.add(leftButton());
        panel.add(rightButton());
        return panel;
    }
    
    public JButton leftButton(){
        JButton button = new JButton("<");
        button.addActionListener(moveLeft());
        return button;
    }
    
    public ActionListener moveLeft(){
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                blockDisplay.block().updatePosx(-10);
                blockDisplay.show();
            }
        };
    }
    
    public JButton rightButton(){
        JButton button = new JButton(">");
        button.addActionListener(moveRight());
        return button;
    }
    
     public ActionListener moveRight(){
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                blockDisplay.block().updatePosx(+10);
                blockDisplay.show();
            }
        };
    }
     
    public void execute() {
        setVisible(true);
    }

}
