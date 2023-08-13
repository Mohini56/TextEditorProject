import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class About {

   //declaration of frame
    JFrame frame;

    //declaration of Label
    JLabel textLabel,iconLabel;


    About(){

        //Initailisation of frame and providing title.
        frame=new JFrame("About TextEditor");
        frame.setLayout(null);
        
        // Add the image in the frame along the frame title.
        ImageIcon img= new ImageIcon("editor.png");
        frame.setIconImage(img.getImage());

        // set the image in the frame with the proper height and width using label.
        iconLabel=new JLabel();
        ImageIcon icon = new ImageIcon("editor.png");
        Image scaleImage = icon.getImage().getScaledInstance(100, 100,Image.SCALE_SMOOTH);
        iconLabel.setIcon(new ImageIcon(scaleImage));
        iconLabel.setLayout(null);
        iconLabel.setBounds(130,10,200,200);
        iconLabel.setVisible(true);

        
        //Adding the text about the textEditor
        
        textLabel=new JLabel("<html>Welcome to the TextEditor<br>TextEditor is a basic text-editing program which<br> enables computer users to create documents.<br>All rights reserved by Mohini_Sharma");
        textLabel.setBounds(50,50,360,350);
        textLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,14));
        
        // to show setBound use setLayout as null
        textLabel.setLayout(null);

       // Now in the Last add the textLabel,IconLabel to the frame.
        frame.add(iconLabel);
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
