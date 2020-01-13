package Control;

import java.awt.BorderLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Snake;
import view.SnakeDisplay;

public class MainFrame extends JFrame {
    private SnakeDisplay snakeDisplay;
    
    public MainFrame() {
        setTitle("snake");
        setSize(600,400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Snake snake = new Snake(10,10, 500/2 -60, 300/2 -40);
        snakeDisplay = new SnakeDisplay(snake);
        this.getContentPane().add(snakeDisplay);
        this.getContentPane().add(toolBar(),BorderLayout.SOUTH);
    }
    
    public JPanel toolBar(){
        JPanel panel = new JPanel();
        panel.add(leftButton(),BorderLayout.WEST);
        panel.add(rightButton(),BorderLayout.EAST);
        panel.add(upButton(),BorderLayout.NORTH);
        panel.add(downButton(),BorderLayout.SOUTH);
        return panel;
    }
    
    public JButton leftButton(){
        JButton button = new JButton("Left");
        button.addActionListener(moveLeft());
        return button;
    }
    
    public ActionListener moveLeft(){
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                snakeDisplay.snake().changeDirection(2);
            }
        };
    }
    
    public JButton rightButton(){
        JButton button = new JButton("Right");
        button.addActionListener(moveRight());
        return button;
    }
    
    public ActionListener moveRight(){
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                snakeDisplay.snake().changeDirection(0);
            }
        };
    }
     
    public JButton upButton(){
        JButton button = new JButton("Up");
        button.addActionListener(moveUp());
        return button;
    }
    
    public ActionListener moveUp(){
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                snakeDisplay.snake().changeDirection(1);
            }
        };
    }
    
    public JButton downButton(){
        JButton button = new JButton("Down");
        button.addActionListener(moveDown());
        return button;
    }
    
     public ActionListener moveDown(){
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                snakeDisplay.snake().changeDirection(3);
            }
        };
    }
     
     
    public void execute() {
        setVisible(true);
    }
}
