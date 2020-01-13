package Controler;

import Model.Image;
import Persistence.FileImageLoader;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\samus\\Documents\\Universidad\\3ro\\Ingenieria del Software 2\\ImageViewer\\imágenes\\");
        FileImageLoader imageLoader = new FileImageLoader(file);
        Image image = imageLoader.load();
        MainFrame mainFrame = new MainFrame();
        mainFrame.getImageDisplay().show(image);
    }
}
