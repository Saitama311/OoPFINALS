import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.*;
import javax.swing.ImageIcon;

public class loginForm extends JFrame  {
    JFrame Fin = new JFrame("Login Form");
    ImageIcon i2 = new ImageIcon("studentLogo.png");
    
    Font f3 = new Font("Monospace", Font.BOLD, 13);
    Font f4 = new Font("Monospace", Font.BOLD, 11);

    JTextField Tuname = new JTextField(20);
    JPasswordField Tpass = new JPasswordField(20);

    public loginForm(){
        Fin.setSize(290, 250);
        Fin.getContentPane().setBackground(Color.decode("#98FB98"));
        Fin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Fin.setLocationRelativeTo(null);
        Fin.setIconImage(i2.getImage());
        JLabel Jbel = new JLabel("Login Form");
        Jbel.setBounds(95, 10, 120, 25);
        Jbel.setFont(f3);
        Fin.add(Jbel);

        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setBounds(10, 50, 80, 25);
        labelUsername.setFont(f4);
        Fin.add(labelUsername);
        
        Tuname.setBounds(100, 50, 165, 25);
        Fin.add(Tuname);

        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(10, 90, 80, 25);
        labelPassword.setFont(f4);
        Fin.add(labelPassword);
        
        Tpass.setBounds(100, 90, 165, 25);
        Fin.add(Tpass);

        JButton buttonLogin = new JButton("LOGIN");
        buttonLogin.setBounds(10, 160, 120, 25);
        buttonLogin.setBackground(Color.decode("#00BFFF"));
        Fin.add(buttonLogin);

        JButton buttonReg = new JButton("REGISTER");
        buttonReg.setBounds(150, 160, 120, 25);
        buttonReg.setBackground(Color.decode("#00BFFF"));
        Fin.add(buttonReg);

        buttonLogin.addActionListener(new buttonLoginListener());
        buttonReg.addActionListener(new buttonRegListener());


        Fin.setLayout(null);
        Fin.setVisible(true);

    }

   public void authentication(){
        String uname= Tuname.getText();
        String pass = Tpass.getText();
        String line = "";
        
        File file = new File("account.txt");
            if(uname.isEmpty() || pass.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please fill up the form");
            }
            try (Scanner scan = new Scanner(file)) {
                while(scan.hasNextLine()){
                    line = scan.nextLine();
                    String[] datasplit = line.split(" , ");
                    if(uname.equals(datasplit[0]) && pass.equals(datasplit[1])){
                        Fin.dispose();
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        new mainMenu();

                       
                    }
                }
            }catch (FileNotFoundException e){ e.printStackTrace();}
            
            Tuname.setText("");
            Tpass.setText("");

           
            
        
    }
    class buttonLoginListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
          authentication();
          

        }
    }

    class buttonRegListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Fin.dispose();
            new registrationForm();
        }
    }

    
    

}
