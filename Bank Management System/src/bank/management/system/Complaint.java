package bank.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;


public class Complaint extends JFrame implements ActionListener{
    
    JTextArea cp;
    JButton back,sub;
    String pin;
    public Complaint(String pin) 
    {
        this.pin=pin;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Kindly enter your Query: ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Georgia",Font.BOLD,16));
        text.setBounds(235,300,400,20);
        image.add(text);
        
        cp=new JTextArea();
        cp.setFont(new Font("Georgia",Font.BOLD,16));
        cp.setBounds(180,330,320,150);
        cp.setLineWrap(true); // Enable line wrapping
        cp.setWrapStyleWord(true);
        image.add(cp);
        
        
        sub=new JButton("Submit");
        sub.setBounds(350,485,150,30);
        sub.addActionListener(this);
        image.add(sub);
        
        
        back=new JButton("Back");
        back.setBounds(350,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==sub)   //agar deposit pe click hua h...
        {
            String qry=cp.getText();
            Date date=new Date();
            if(qry.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter Query!");   //warning if user doesn't enter amount to deposit
            }
            else
            {
                try{
                    Conn conn=new Conn();
                    String query="insert into complaint values('"+pin+"','"+date+"','"+qry+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Your Query has been Registered, we'll get back to you in 12-24 Hours. Stay Connected!!");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);   //complaint register hote hi transaction display khul jayega...x
                }
                catch(Exception e)
                {
                    System.out.print(e);
                }
            }
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }
    
    public static void main(String arg[])
    {
        Complaint comp = new Complaint("");
        comp.setVisible(true);
    }
}
