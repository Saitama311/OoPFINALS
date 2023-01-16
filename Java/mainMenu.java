import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class mainMenu {
    JFrame MeynM = new JFrame("School Information System");
    public mainMenu(){
        MeynM.setSize(290, 170);
        MeynM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MeynM.setLocationRelativeTo(null);

        MeynM.setLayout(null);

        JButton Alist = new JButton("Account List");
        Alist.setBounds(50, 10, 200, 25);
        Alist.addActionListener(new AlistListener());
        MeynM.add(Alist);
    
       
        JButton Bdent = new JButton("Student Information");
        Bdent.setBounds(50, 50, 200, 25);
        Bdent.addActionListener(new BdentListener());
        MeynM.add(Bdent);

        JButton Bout = new JButton("Logout");
        Bout.setBounds(50, 90, 200, 25);
        Bout.addActionListener(new BoutListener());
        MeynM.add(Bout);
        
        MeynM.setVisible(true);
        
    }

    class AlistListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            MeynM.dispose();
            new accountPage();
        }
    }
    class BdentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            MeynM.dispose();
            new studentPage();
            
            
        }
    }

    class BoutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            MeynM.dispose();
            new loginForm();
        }
    }


}
