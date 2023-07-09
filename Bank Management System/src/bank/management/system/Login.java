package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

        
//JFrame is used to create Framed App, ActionListener is interface used for performing actions if we click on any Button
public class Login extends JFrame implements ActionListener{ 
    JButton login,signup,clr; 
    JTextField ctf;
    JPasswordField cpin;   //pin should be like invisible, so choosing password
    Login(){
        setTitle("Indian Bank ATM");  //setting up title
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpeg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(120,10,100,100);
        add(label); 
    
        JLabel text=new JLabel("Welcome to Indian Bank");    //label created for Text msg "Welcome to ATM"
        text.setFont(new Font("Georgia",Font.BOLD,30));   //setting up Font size, Style 
        text.setBounds(250,40,500,40);           //text msg Position
        add(text);      //adding to Application
        
        
        JLabel cardno=new JLabel("Card No:");    //label created for Text msg Card No.
        cardno.setFont(new Font("Raleway",Font.BOLD,22));   //setting up Font size, Style 
        cardno.setBounds(120,150,150,30);           //cardno msg Position
        add(cardno);  
        ctf=new JTextField();   //adding text box in front of cardno.
        ctf.setBounds(300, 150, 230, 30);  //setting dimensions
        ctf.setFont(new Font("Arial",Font.BOLD,16));
        add(ctf);    //adding to the app
        
        
        JLabel pin=new JLabel("PIN:");    //label created for Text msg "PIN"
        pin.setFont(new Font("Raleway",Font.BOLD,22));   //setting up Font size, Style 
        pin.setBounds(120,220,250,30);           //PIN Position
        add(pin);   
        cpin=new JPasswordField();    //text box in front of pin 
        cpin.setBounds(300, 220, 230, 30);
        cpin.setFont(new Font("Arial",Font.BOLD,16));
        add(cpin);
        
        
        login=new JButton("LOGIN");  //creating login in button
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
        clr=new JButton("CLEAR");  //creating CLEAR button
        clr.setBounds(430,300,100,30);
        clr.setBackground(Color.BLACK);
        clr.setForeground(Color.WHITE);
        clr.addActionListener(this);
        add(clr);
                
        
        signup=new JButton("SIGN UP");  //creating login in button
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
                
        getContentPane().setBackground(Color.WHITE);  //white background
        setSize(800,480); //we are creating system on a App like thing, so this function will set the dimensions of frame
        setVisible(true);   //this will display the frame at top left screen
        setLocation(350,200);  //350 units left se, and 200 units top se
    }
    
    
   public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == clr) 
    {
        ctf.setText("");
        cpin.setText("");
    } 
    else if (ae.getSource() == login)   //if user clicks on Login
    {
        Conn conn=new Conn();
        String cardno=ctf.getText();
        String pin=cpin.getText();
        String query="select * from login where Card_Number= '"+cardno+"' and PIN_Number='"+pin+"'";
        
        try{
            ResultSet rs=conn.s.executeQuery(query);  //query results will be stored in ResultSet
            if(rs.next())       //agar rs ke next me data hai...
            {
                setVisible(false);   //agar login krne pe data h, to ye frame close ho jyga
                new Transaction(pin).setVisible(true);   //passing pin number, agar ek baar pin daal diya to vapas nai daalna hoga
            }
            else  //agar nahi hai, to mtlb galat credentials hai
            {
                JOptionPane.showMessageDialog(null,"INVALID Credentials");
            }
        }catch(Exception e){
            System.out.print(e);
        }
    } 
    else if (ae.getSource() == signup) {
        setVisible(false);  //signup pe click krte hi login tab bandd hoga,
        new Signup1().setVisible(true);  //aur yaha se shuru ho jyga...    
    }
   }
    
    public static void main(String[] args) {
        new Login();
    }
}
