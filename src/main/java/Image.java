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
       frame.setBounds(100,600,500,350);
    frame.setVisible(true);
    }


    }




