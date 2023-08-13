import com.sun.source.doctree.AttributeTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextEditor implements ActionListener {
    //Declaring properties of TextEditor
    JFrame frame;

    // declaring the menuBar in the frame
    JMenuBar menuBar;

    // declaring the menu inside the menuBar
    JMenu file,edit,theme,help ;

    // declaring the menuItem inside the menu
    JMenuItem newFile, openFile, saveFile,print,exit; // for the file menu
    JMenuItem cut,copy,paste,selectAll,fontSize; // for the edit menu
    JMenuItem darkTheme,lightTheme; // for the theme menu
    JMenuItem AboutTextEditor; // for the help menu

    // declaring the textArea
    JTextArea TextArea;

    //declaring scroll Pane
    JScrollPane scroll;

    TextEditor(){
        // Initialize a frame
        frame=new JFrame("Text Editor");

        frame.getRootPane().setBorder(
                BorderFactory.createMatteBorder(2, 0, 4, 0, Color.LIGHT_GRAY)
        );
        // add image in the frame using ToolKit

        Image img= Toolkit.getDefaultToolkit().getImage("C:\\Users\\MOHINI SHARMA\\Downloads\\editor.png");
        frame.setIconImage(img);


        //Initialize a MenuBar
        menuBar=new JMenuBar();

        //Initialize the textArea
        TextArea=new JTextArea();

        //Initialize the menu Inside the menuBar
        file=new JMenu("File");
        edit=new JMenu("Edit");
        theme=new JMenu("Theme");
        help=new JMenu("Help");

        // Now initialize the menuItem
        newFile=new JMenuItem("New File");
        openFile=new JMenuItem("Open");
        saveFile=new JMenuItem("Save");
        print=new JMenuItem("Print");
        exit=new JMenuItem("Exit");

        //Add Action Listener to file menu
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        print.addActionListener(this);
        exit.addActionListener(this);

        // In file menu add these above items
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(print);
        file.add(exit);

        // Now Initialize the menuItem for edit menu
        cut=new JMenuItem("Cut");
        copy=new JMenuItem("Copy");
        paste=new JMenuItem("Paste");
        selectAll=new JMenuItem("Select All");
        fontSize=new JMenuItem("Font Size");

        // Add ActionListener to edit menu
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        fontSize.addActionListener(this);

        //In Edit menu add these above items
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(fontSize);

        //Now Initialize the menuItem for Theme menu
        darkTheme=new JMenuItem("Dark");
        lightTheme=new JMenuItem("Light");

        //Add ActionListener to Theme menu
        darkTheme.addActionListener(this);
        lightTheme.addActionListener(this);

        //In theme menu add these above 2 items
        theme.add(darkTheme);
        theme.add(lightTheme);

        // Now Initialize the menuItem for Help menu
        AboutTextEditor= new JMenuItem("About");

        //Add ActionListener
        AboutTextEditor.addActionListener(this);

        //In Help menu add About TextEditor
        help.add(AboutTextEditor);

        //Now add the menu inside the menuBar
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(theme);
        menuBar.add(help);


        // set Keyboard keys to the particular menuItem
        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK));

        // set menuBar to frame
        frame.setJMenuBar(menuBar);

        // set textArea to frame
        frame.add(TextArea);

        // set scroll Pane
        scroll=new JScrollPane(TextArea);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame.add(scroll);


        // Set dimension of frame
        frame.setBounds(300,200,900,500);
        frame.setVisible(true);
        frame.setLayout(null);



    }
    // ActionEvent Listen to actionListener in TextEditor and perform operations
    // TextEditor(ActionListener) --> ActionEvent --> actionPerformed()
    @Override
    public void actionPerformed(ActionEvent actionEvent){
           if(actionEvent.getSource()==cut){
               // inbuilt methods in actionEvent
                TextArea.cut();
           }
           if(actionEvent.getSource()==copy){
                TextArea.copy();
           }
           if(actionEvent.getSource()==paste){
                TextArea.paste();
           }
           if(actionEvent.getSource()==selectAll){
                TextArea.selectAll();
           }
           if(actionEvent.getSource()==openFile) {
               /* JFileChooser is used to show the system dialog to the user so that
                    they can file or directory*/
               JFileChooser fileChooser = new JFileChooser("C:");

               //open/cancel option in the dialog
               int chooseOption = fileChooser.showOpenDialog(null);

               // if the chooseOption is open then
               if (chooseOption == JFileChooser.APPROVE_OPTION) {
                   // then selected the file need to open
                   File file = fileChooser.getSelectedFile();

                   // then Get the path of the selected file
                   String filePath = file.getPath();
                   try {
                       // After getting file need to read the file & then copy into the textarea
                       // for File reading initialize the FileReader
                       FileReader fileReader = new FileReader(filePath);

                       //initialize the buffer reader
                       BufferedReader bufferedReader = new BufferedReader(fileReader);

                       /*Now create 2 strings one as current line
                         and other as result string having all contents of the file
                        */
                       String current = "", result = "";

                       // read contents of the file line by line
                       while ((current = bufferedReader.readLine()) != null) {
                           result += current + "\n";
                       }
                       // then finally copy the line into the textEditor
                       TextArea.setText(result);
                   } catch (IOException FileNotFoundException) {
                       FileNotFoundException.printStackTrace();

                   }

               }
           }
           if(actionEvent.getSource()==saveFile) {
                   JFileChooser fileChooser = new JFileChooser("C:");

                   int chooseOption = fileChooser.showSaveDialog(null);

                   if (chooseOption == JFileChooser.APPROVE_OPTION) {

                       // It create a new file contain selectedFile + newFileName + .txt
                       File file = new File(fileChooser.getSelectedFile().getAbsolutePath() + ".txt");

                       try {
                           // initialize the file writer
                           FileWriter fileWriter = new FileWriter(file);

                           BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                           // add the content of the textArea in the new file
                           TextArea.write(bufferedWriter);
                           bufferedWriter.close();
                       } catch (IOException ioException) {
                           ioException.printStackTrace();
                       }
                   }
           }
           if(actionEvent.getSource()==newFile){
               TextEditor newTextEditor=new TextEditor();
           }
           if(actionEvent.getSource()==print) {
               try {
                   TextArea.print();
               }
               // if printer is not connected
               catch(PrinterException e){
                   Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE,null,e);
               }

           }
           if(actionEvent.getSource()==exit){
               System.exit(0);
           }
           if(actionEvent.getSource()==darkTheme){
               TextArea.setBackground(Color.DARK_GRAY);
               TextArea.setForeground(Color.WHITE);
           }
           if(actionEvent.getSource()==lightTheme){
               TextArea.setBackground(new Color(255,255,255));
               TextArea.setForeground(Color.black);
           }
           if(actionEvent.getSource()==fontSize) {
               // take input of font size using input dialog
               String setOfFont = JOptionPane.showInputDialog("Enter Font Size", JOptionPane.OK_CANCEL_OPTION);
               if (setOfFont != null) {
                   int fontSize = Integer.parseInt(setOfFont);
                   // font family, font type, font size
                   Font font = new Font(Font.SANS_SERIF, Font.PLAIN, fontSize);
                   TextArea.setFont(font);
               }

           }
           if(actionEvent.getSource()==AboutTextEditor){
               About about=new About();
           }


    }
    public static void main(String[] args){
        TextEditor textEditor=new TextEditor();
    }
}
