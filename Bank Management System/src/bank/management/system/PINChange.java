package bank.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PINChange extends JFrame implements ActionListener{
    
    String pin;
    JPasswordField pi,pinew;
    JButton change,back;
    PINChange(String pin)
    {
        this.pin=pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        
        
        JLabel text=new JLabel("Change your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Georgia",Font.BOLD,18));
        text.setBounds(270, 280, 500, 20);
        image.add(text);
        
        JLabel p=new JLabel("New PIN: ");
        p.setForeground(Color.WHITE);
        p.setFont(new Font("Georgia",Font.BOLD,16));
        p.setBounds(165, 320, 180, 25);
        image.add(p);
        
        pi=new JPasswordField();
        pi.setFont(new Font("Raleway",Font.BOLD,20));
        pi.setBounds(330,320,180,25);
        image.add(pi);
        
        JLabel np=new JLabel("Re-enter New PIN: ");
        np.setForeground(Color.WHITE);
        np.setFont(new Font("Georgia",Font.BOLD,16));
        np.setBounds(165, 360, 180, 25);
        image.add(np);
        
        pinew=new JPasswordField();
        pinew.setFont(new Font("Raleway",Font.BOLD,20));
        pinew.setBounds(330,360,180,25);
        image.add(pinew);
        
        
        change=new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        
        back=new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);    
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==change)   //agar change button pe click hua..
        {
            try{
            String npin=pi.getText();
            String rpin=pinew.getText();
            
            if(!npin.equals(rpin))
            {
                JOptionPane.showMessageDialog(null,"Entered PIN doesn't match");
            }
            
            if(npin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter new PIN!!");   //if pin is unentered and u want to submit the request
                return;
            }
            
            if(rpin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Re-enter new PIN!!");   //if pin is unentered and u want to submit the request
                return;
            }
            
            Conn c1=new Conn();
            //we need to write here 3 queries bcoz, pin is used in 3 tables bank,login,signup3
            String q1 = "update bank set pin= '"+rpin+"' where pin = '"+pin+"' ";
            String q2 = "update login set PIN_Number = '"+rpin+"' where PIN_Number = '"+pin+"' ";
            String q3 = "update signup3 set PINNumber = '"+rpin+"' where PINNumber = '"+pin+"' ";
            
            c1.s.executeUpdate(q1);
            c1.s.executeUpdate(q2);
            c1.s.executeUpdate(q3);
            
            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            setVisible(false);   //change hote hi transaction page open hoga..
            new Transaction(rpin).setVisible(true);  //rpin aayega, no new hoga, ab last one has been deleted
        }catch(Exception e)
        {
            System.out.print(e);
        }
        }
        else       //agar cancel button pe click hua....
        {
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }
    public static void main(String arg[])
    {
        new PINChange("").setVisible(true);
    }
}
