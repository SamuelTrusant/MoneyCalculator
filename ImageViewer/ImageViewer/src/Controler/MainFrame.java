package Controler;

import UI.ImageDisplay;
import UI.SwingImageDisplay;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    
    private ImageDisplay imageDisplay;
    
    public MainFrame(){
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imageDisplay());
        this.getContentPane().add(toolBar(),BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    private JPanel toolBar(){
        JPanel panel = new JPanel();
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }

    private JButton prevButton() {
        JButton button = new JButton("<");
        button.addActionListener(prevImage());
        return button;
    }

    private ActionListener prevImage(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                imageDisplay.show(imageDisplay.Current().prev());
            }
        };
    }
    private JButton nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(nextImage());
        return button;
    }

    private ActionListener nextImage() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                imageDisplay.show(imageDisplay.Current().next());
            }
        };
    }

    private JPanel imageDisplay() {
        SwingImageDisplay dis = new SwingImageDisplay();
        this.imageDisplay = dis;
        return dis;
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
}
