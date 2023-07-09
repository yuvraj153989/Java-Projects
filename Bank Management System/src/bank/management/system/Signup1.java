package bank.management.system;
import java.awt.Color;
import javax.swing.*;              //new class for Signup button, it will contain form like thing for creating new user..
import java.awt.*;          //for colors
import java.util.*;
import com.toedter.calendar.JDateChooser;   //for date year box
import java.awt.event.*;


public class Signup1 extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField,fnameTextField,dobTextFied,emailTextField,adTextField,cityTextField,stateTextField,pinTextField,cntryTextField;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
    JButton next;
    JRadioButton male,female,other,pfr,mar,un;
    JDateChooser dc;
    
    Signup1()           //signup class
    {
        setLayout(null);
        Random ran=new Random();
        long random=Math.abs((ran.nextLong() % 9000L) + 1000L);            //taking random number 
        JLabel formno=new JLabel("Application Registration No: "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,800,40);
        add(formno);
        
        
        JLabel personalDetails=new JLabel("Index 1: Personal Details");  //taking personal details
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        
        JLabel name=new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,20));        //adding your name
        name.setBounds(100,140,100,30);
        add(name);
        nameTextField=new JTextField();        //adding text box, where input will be taken 
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        
        JLabel fthr=new JLabel("Fathers Name: ");        //adding fathers name
        fthr.setFont(new Font("Raleway",Font.BOLD,20));
        fthr.setBounds(100,190,200,30);
        add(fthr);
        fnameTextField=new JTextField();        //adding text box, where input will be taken 
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        
        JLabel dob=new JLabel("Date of Birth(DOB): ");     //addnig Date of Birth
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
//        dobTextFied=new JTextField();        //adding text box, where input will be taken 
//        dobTextFied.setFont(new Font("Raleway",Font.BOLD,14));
//        dobTextFied.setBounds(100,240,200,20);
//        add(dobTextFied);
        dc=new JDateChooser();
        dc.setBounds(300,240,400,30);
        dc.setForeground(Color.BLACK);
        add(dc);
        
        
        
        JLabel gender=new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female=new JRadioButton("Female");    //adding and customizing Male/Female option radio buttons
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        pfr=new JRadioButton("Prefer Not to Say");
        pfr.setBounds(600,290,180,30);
        pfr.setBackground(Color.WHITE);
        add(pfr);
        
        ButtonGroup gendergrp=new ButtonGroup();
        gendergrp.add(male);
        gendergrp.add(female);
        gendergrp.add(pfr);

        
        
        JLabel email=new JLabel("Email Address: ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        emailTextField=new JTextField();        //adding text box, where input will be taken 
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
        
        
        JLabel marital=new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        mar=new JRadioButton("Married");
        mar.setBounds(300,390,100,30);
        mar.setBackground(Color.WHITE);
        add(mar);
        
        un=new JRadioButton("Unmarried");    //adding and customizing Male/Female option radio buttons
        un.setBounds(450,390,100,30);
        un.setBackground(Color.WHITE);
        add(un);
        
        other=new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup mrtlgrp=new ButtonGroup();
        mrtlgrp.add(mar);      //if one option is selected, this will make sure that other will be deselected
        mrtlgrp.add(un);
        mrtlgrp.add(other);
        
        
        
        JLabel address=new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        adTextField=new JTextField();        //adding text box, where input will be taken 
        adTextField.setFont(new Font("Raleway",Font.BOLD,14));
        adTextField.setBounds(300,440,400,30);
        add(adTextField);
        
        
        JLabel city=new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        cityTextField=new JTextField();        //adding text box, where input will be taken 
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        
        JLabel state=new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        stateTextField=new JTextField();        //adding text box, where input will be taken 
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        
        JLabel pincode=new JLabel("PIN Code: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        pinTextField=new JTextField();        //adding text box, where input will be taken 
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);
        
        
        JLabel cntry=new JLabel("Country: ");
        cntry.setFont(new Font("Raleway",Font.BOLD,20));
        cntry.setBounds(100,640,200,30);
        add(cntry);
        cntryTextField=new JTextField();        //adding text box, where input will be taken 
        cntryTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cntryTextField.setBounds(300,640,400,30);
        add(cntryTextField);
        
        
        
        
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
        String formno=""+random;   //long value...converting it into string
        String name=nameTextField.getText();      //fetching values 
        String fname=fnameTextField.getText();
        String dob = ((JTextField) dc.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
            gender="Female";
        }
        else{
            gender="Prefer Not to Say";
        }
        String email=emailTextField.getText();
        String marital=null;
        if(mar.isSelected()){
            marital="Married";
        }
        else if(un.isSelected()){
            marital="Unmarried";
        }
        else{
            marital="Others";
        }
        String address=adTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pin=pinTextField.getText();
        String country=cntryTextField.getText();
        
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");  //showing error dialogue box
            } else{
                Conn c=new Conn();
                String q1 = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"','"+country+"')";
                c.s.executeUpdate(q1);
                
                setVisible(false);        //next click krne pe Signup2 khulega
                new Signup2(formno).setVisible(true);   //opening signup2..passing formno coz its primary key, and carried to next page as well
            }
        }catch(Exception e){
            System.out.print(e);
        }
    }
    public static void main(String args[]) {
        new Signup1();
    }
}
