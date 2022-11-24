import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class frm_MenuPrincipal extends JFrame {

    public static void main(String[] args) {

        MyLabel myLabel = new MyLabel(); //create label

        MyPanel myPanel = new MyPanel(); //create panel

        MyFrame myFrame = new MyFrame(myLabel, myPanel); //create frame
    }

    public static class MyLabel extends JLabel{
        MyLabel(){
            this.setText("How are you?"); //set text of label

            ImageIcon image = new ImageIcon("images/doctor.png");
            Border border = BorderFactory.createLineBorder(Color.GREEN); //external border

            this.setIcon(image);//insert image to label
            this.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of image icon
            this.setVerticalTextPosition(JLabel.TOP); //set text TOP, BoTTOM, CENTER of iamge Icon,
            this.setForeground(Color.ORANGE); //set font color of text
            this.setFont(new Font("Times New Roman", Font.PLAIN,20)); //set style font odf text
            this.setIconTextGap(30); //set gap of text to image
            this.setBackground(Color.DARK_GRAY); //set backbround color
            this.setOpaque(true); //display backbround color
            this.setBorder(border);
            this.setVerticalAlignment(JLabel.CENTER); //set vertical position of icon+text within label
            this.setHorizontalAlignment(JLabel.CENTER); //set horizontal postion of icon9text within label
            //this.setBounds(0,0,500,1000); //set x,y position within frame as well as dimensions
        }

    }

    public static class MyFrame extends JFrame {
        MyFrame(JLabel myLabel, JPanel myPanel) {

            this.setTitle("Window"); //set tittle
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
            this.setResizable(true); //prevent frame from being resized
            this.setSize(420, 420); // sets the windows dimension
            this.setVisible(true); //make frame visible
            //this.setLayout(null);
            //this.pack();

            ImageIcon image = new ImageIcon("images/hospital.jpg"); // Create an Imgaeicon
            this.setIconImage(image.getImage()); // change icon of frame

            this.getContentPane().setBackground(Color.WHITE); //change color of background
            //this.getContentPane().setBackground(new Color(20,150,34)); //change color of background RGB
            //this.getContentPane().setBackground(new Color(800000));

            this.add(myLabel);
        }
    }

    public static class MyPanel extends JPanel{
        MyPanel(){
            this.
        }
    }
}
