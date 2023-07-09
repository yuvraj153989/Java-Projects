package bank.management.system;
import java.awt.Color;
import javax.swing.*;              //new class for Signup button, it will contain form like thing for creating new user..
import java.awt.*;          //for colors
import java.util.*;
import com.toedter.calendar.JDateChooser;   //for date year box
import java.awt.event.*;


public class Signup2 extends JFrame implements ActionListener{
    
    JTextField panTextField, aadharTextField,srTextField,exTextField;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
    JButton next;
    JComboBox religion, cat, income, education, occ; 
    String formno;
    
    Signup2(String formno)           //signup class, formno will be carried here as well
    {
        this.formno=formno;      //initializing form no
        setLayout(null);
        setTitle("New Account Application, Page 2");
        
        
        JLabel addDetails=new JLabel("Index 2: Additional Details");  //taking personal details
        addDetails.setFont(new Font("Raleway",Font.BOLD,22));
        addDetails.setBounds(290,80,400,30);
        add(addDetails);
        
        
        JLabel name=new JLabel("Religion: ");
        name.setFont(new Font("Raleway",Font.BOLD,20));        //adding your religion dropdown menu option system
        name.setBounds(100,140,100,30);
        add(name);
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Others"};
        religion=new JComboBox(valReligion);
        religion.setBackground(Color.WHITE);
        religion.setBounds(300,140,400,30);
        add(religion);
        
        
        JLabel fthr=new JLabel("Category: ");        //adding fathers name
        fthr.setFont(new Font("Raleway",Font.BOLD,20));
        fthr.setBounds(100,190,200,30);
        add(fthr);
        String valcat[]={"General","OBC","SC","ST","Others"};
        cat=new JComboBox(valcat);
        cat.setBackground(Color.WHITE);
        cat.setBounds(300,190,400,30);
        add(cat);
        
        
        JLabel dob=new JLabel("Income: ");     //addnig Date of Birth
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        String incomecat[]={"NIL","< 1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income=new JComboBox(incomecat);
        income.setBackground(Color.WHITE);
        income.setBounds(300,240,400,30);
        add(income);
        
        
        JLabel email=new JLabel("Qualification: ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,290,200,30);
        add(email);
        String edcat[]={"Non-Grad","Graduated","Post-Graduated","Doctorate","Others"};
        education=new JComboBox(edcat);
        education.setBackground(Color.WHITE);
        education.setBounds(300,290,400,30);
        add(education);
        
        
        
        JLabel marital=new JLabel("Occupation: ");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,340,200,30);
        add(marital);
        String occcat[]={"Central Government","Defence Services","Private","Self-Employed","Business","Student","Retired","Others"};
        occ=new JComboBox(occcat);
        occ.setBackground(Color.WHITE);
        occ.setBounds(300,340,400,30);
        add(occ);
  
        
        
        JLabel pan=new JLabel("PAN No.: ");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,390,200,30);
        add(pan);
        panTextField=new JTextField();        //adding text box, where input will be taken 
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,390,400,30);
        add(panTextField);
        
        
        JLabel aadhar=new JLabel("Aadhar No.: ");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100,440,200,30);
        add(aadhar);
        aadharTextField=new JTextField();        //adding text box, where input will be taken 
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,440,400,30);
        add(aadharTextField);
        
        
        JLabel sr=new JLabel("Senior Citizen: ");
        sr.setFont(new Font("Raleway",Font.BOLD,20));
        sr.setBounds(100,490,200,30);
        add(sr);
        srTextField=new JTextField();        //adding text box, where input will be taken 
        srTextField.setFont(new Font("Raleway",Font.BOLD,14));
        srTextField.setBounds(300,490,400,30);
        add(srTextField);
        
        
        
        JLabel ex=new JLabel("Existing Account: ");
        ex.setFont(new Font("Raleway",Font.BOLD,20));
        ex.setBounds(100,540,200,30);
        add(ex);
        exTextField=new JTextField();        //adding text box, where input will be taken 
        exTextField.setFont(new Font("Raleway",Font.BOLD,14));
        exTextField.setBounds(300,540,400,30);
        add(exTextField);
        
        
        
       
        
        next=new JButton("Next...");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(620,700,80,30);
        next.addActionListener(this);
        add(next);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(930,800);       //setting size of new created frame
        setLocation(350,10);         //setting location, left se 350units, right se 10 unit
        setVisible(true);          //make that frame visible
    }
    public void actionPerformed(ActionEvent ae)  //creating functions for buttons
    {
        
        String relg=(String)religion.getSelectedItem(); //typecasting into string, kyuki religion is object returning fnctn
        String catg=(String)cat.getSelectedItem();
        String inc=(String)income.getSelectedItem();
        String edc=(String)education.getSelectedItem();
        String occp=(String)occ.getSelectedItem();
        String pancard=panTextField.getText();      //fetching values 
        String aadharcard=aadharTextField.getText();
        String gender=null;
        String senior=srTextField.getText();
        String exist=exTextField.getText();
        
        try{
            Conn c=new Conn();
            String query = "insert into signup2 values('"+formno+"','"+relg+"','"+catg+"','"+inc+"','"+edc+"','"+occp+"','"+pancard+"','"+aadharcard+"','"+senior+"','"+exist+"')";
            c.s.executeUpdate(query);
            
            //signup3 class
            setVisible(false);
            new Signup3(formno).setVisible(true);
        }catch(Exception e){
            System.out.print(e);
        }
    }
    public static void main(String args[]) {
        new Signup2("");   //empty string, parametrized constructor, values already passed
    }
}
