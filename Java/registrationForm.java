import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import java.awt.Font;
public class registrationForm extends JFrame   {
  
    JFrame Fter = new JFrame("Register");
    ImageIcon i = new ImageIcon("studentLogo.png");
    JTextField Tuname = new JTextField(50);
    JPasswordField Tpass = new JPasswordField(50);
    JTextField Tmail = new JTextField(50);
    Font f = new Font("Monospace", Font.BOLD, 13);
    Font f2 = new Font("Monospace", Font.BOLD, 11);
    public registrationForm() {
       
        Fter.setSize(290, 250);
        Fter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Fter.setLocationRelativeTo(null);
        
        Fter.setIconImage(i.getImage());

        Fter.getContentPane().setBackground(Color.decode("#00FF7F"));
      
        Fter.setLayout(null);
        
        JLabel Jbel = new JLabel("School Management System");
        Jbel.setBounds(75, 10, 500, 25);
        Jbel.setFont(f);
        Fter.add(Jbel);
        
        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setBounds(10, 50, 80, 25);
        Fter.add(labelUsername);
        labelUsername.setFont(f2);
       
        Tuname.setBounds(100, 50, 165, 25);
        Fter.add(Tuname);
        

        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(10, 80, 80, 25);
        Fter.add(labelPassword);
        labelPassword.setFont(f2);
        
        Tpass.setBounds(100, 80, 165, 25);
        Fter.add(Tpass);


        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(10, 110, 80, 25);
        Fter.add(labelEmail);
        labelEmail.setFont(f2);
        
        Tmail.setBounds(100, 110, 165, 25);
        Fter.add(Tmail);

        //Register Button
        JButton buttonReg = new JButton("REGISTER");
        buttonReg.setBounds(10, 160, 120, 25);
        buttonReg.setBackground(Color.decode("#4169E1"));
        buttonReg.setFont(f2);
        
        Fter.add(buttonReg);
        
        //Login Button
        JButton buttonLogin = new JButton("LOGIN");
        buttonLogin.setBounds(150, 160, 120, 25);
        buttonLogin.setBackground(Color.decode("#4169E1"));
        buttonLogin.setFont(f2);
        Fter.add(buttonLogin);

        
        buttonReg.addActionListener(new ButtonRegListener());
        buttonLogin.addActionListener(new ButtonLoginListener());

        Fter.setVisible(true);
       

    }

  


    class ButtonRegListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String uname = Tuname.getText();
            String pass = Tpass.getText();
            String email = Tmail.getText();
            
        if(!uname.isEmpty() && !pass.isEmpty() && !email.isEmpty()){
            try{
                File file = new File("account.txt");
                FileWriter fileWriter = new FileWriter(file,true);
                fileWriter.write(uname + " , " + pass + " , " + email+ "\n");
                JOptionPane.showMessageDialog(null, "Registration Successful");
                fileWriter.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                Tuname.setText("");
                Tpass.setText("");
                Tmail.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Please fill in all the fields");
        }
        }
    }
    
    class ButtonLoginListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Fter.dispose();
            new loginForm();
        }
    }

   


   
    
}
