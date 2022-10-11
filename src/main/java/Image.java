//this file is used to add images to gui
import javax.swing.*;


public class Image extends JFrame {

    JFrame frame;
    JLabel displayField;
    ImageIcon image;

    public Image(String picture) {
     frame = new JFrame();
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            image = new ImageIcon((getClass().getResource(picture)));
            System.out.println(image);

           displayField = new JLabel(image);
            frame.add(displayField);
        } catch (Exception e) {
            System.out.println("image not found");
        }
        frame.setSize(400,400);
       frame.setBounds(100,600,500,350);
    frame.setVisible(true);
    }


    }




// use video for refrence https://www.youtube.com/watch?v=ntirmRhy6Fw&t=300s