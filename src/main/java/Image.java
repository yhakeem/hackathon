import javax.swing.*;
import java.util.Objects;

public class Image extends JFrame {

    JFrame frame;
    JLabel displayField;
    ImageIcon image;

    public Image() {
        frame = new JFrame("Image display test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            image = new ImageIcon(Objects.requireNonNull(getClass().getResource("istock-1154231467.jpeg")));
            displayField = new JLabel(image);
        } catch (Exception e) {
            System.out.println("image not found");
        }
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Image i=new Image();
    }
}



