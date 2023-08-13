import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class About {

    // Already added JFrame property using extends no need to initialise

    // Already added JFrame property using extends no need to initialise
    JFrame frame;

    JLabel textLabel,iconLabel;


    About(){

        frame=new JFrame("About TextEditor");
        frame.setLayout(null);
        // provide the image location
        ImageIcon img= new ImageIcon("editor.png");
        frame.setIconImage(img.getImage());

        // set the image in proper direction using label
        iconLabel=new JLabel();
        ImageIcon icon = new ImageIcon("editor.png");
        Image scaleImage = icon.getImage().getScaledInstance(100, 100,Image.SCALE_SMOOTH);
        iconLabel.setIcon(new ImageIcon(scaleImage));
        iconLabel.setLayout(null);
        iconLabel.setBounds(130,10,200,200);
        iconLabel.setVisible(true);
        frame.add(iconLabel);


        textLabel=new JLabel("<html>Welcome to the TextEditor<br>TextEditor is a basic text-editing program which<br> enables computer users to create documents.<br>All rights reserved by Mohini_Sharma");
        textLabel.setBounds(50,50,360,350);
        textLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,14));
        // to show setBound use setLayout as null
        textLabel.setLayout(null);


        frame.add(textLabel);
        frame.setBounds(600,400,400,350);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);
    }

    public static void main(String[] args){
          About about=new About();
    }
}
