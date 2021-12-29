import javax.swing.*;  //multiplication tabel code
import java.awt.*;
import java.awt.event.*;//for action listener

public class Test extends JFrame{
    private Container c;
    private JLabel imgLabel,textLabel;
    private JTextArea ta;
    private JTextField tf;
    private JButton clearButton;
    private ImageIcon img;
    private Font f;
    private Cursor cursor;//hand cursor

    Test()//constracter
    {
        b();//method
    }

    //above method description
    public void b()
    {
        c=this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.ORANGE);

        f=new Font("Arial",Font.BOLD,20);//create font 

        img=new ImageIcon(getClass().getResource("download.jpg"));//print image
        imgLabel=new JLabel(img);
        imgLabel.setBounds(20,10,img.getIconWidth(),img.getIconHeight());//get unknown hight width from image
        c.add(imgLabel);

        //print txt
        textLabel=new JLabel("Enter any number :");
        textLabel.setBounds(20,200,250,50);
        textLabel.setForeground(Color.magenta);//text color set
        textLabel.setFont(f);//set font
        c.add(textLabel);
//create text field
        tf=new JTextField();
        tf.setBounds(230,200,90,50);
        tf.setBackground(Color.black);
        tf.setForeground(Color.green);
        tf.setHorizontalAlignment(JTextField.CENTER);//text alignment
        tf.setFont(f);
        c.add(tf);

        //create HAND cursor
        cursor=new Cursor(Cursor.HAND_CURSOR);

        //create clear button
        clearButton=new JButton("Clear");
        clearButton.setBounds(240,260,70,30);
        clearButton.setCursor(cursor);//use hand cursor
        //clearButton.setFont(f);//set font style of button
        c.add(clearButton);

        //text area
        ta=new JTextArea();
        ta.setBounds(20,350,300,300);
        //ta.setBackground(Color.gray);
        ta.setForeground(Color.green);
        ta.setFont(f);
        c.add(ta);
//action listener for text field
        tf.addActionListener(new ActionListener(){//text field er sathe action listener add

            public void actionPerformed(ActionEvent e)//'e' action event obj
            {
                String value=tf.getText();//1st e check korbe kono value ache ki na thakle "value"er moddhe store hobe
                if(value.isEmpty())//text field empty obosthai enter press korle "enter number" below message show korbe
                {
                    JOptionPane.showMessageDialog(null, "please enter any number");
                }
                else
                {
                 ta.setText("");//text area te 12 likhe enter press korar por text area te 12 muche 10 likhle
                                 //12 er numter por 10 er numta jate na dhekhai ter jonno prothek ber text area clear korbe
                int num=Integer.parseInt(tf.getText());//inputed number scan korbe and string to int e convert kore num e store korbe
//imputed number ta string type so,parseint er maddhome int e convert korte hobe
                for(int i=1;i<=10;i++)
                {
                    int result=num*i;//num=inputed number
                    String r=String.valueOf(result);//text area work only with string//result ta string e nite hobe
                    //string r holo r akta string type
                    String n=String.valueOf(num);//num+ inputed number
                    String incr=String.valueOf(i);

                    ta.append(n+"x"+incr+"="+r+"\n");//to show total list of multiplication  'append' is used to do that.
                    //ta.set text use korle por por list ta show korbe na
                }
                }
                
            }
        });
//action listener for button
        clearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ta.setText("");//text area clear hobe
                tf.setText("");
            }
        });

    }

public static void main(String[]args)
   {
     Test a=new Test();
     a.setVisible(true);//to visible app
     a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     a.setBounds(300,20,360,700);
     a.setTitle("Multiplication Table");
     a.setResizable(false);//do not abel to resize
    }
}
