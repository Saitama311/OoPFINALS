
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class accountPage{
    DefaultTableModel model;
    JTable Lamesa;
    String[][] Laman;
    String[] Cnames = {"Username", "Password", "Email"};
    JFrame Facc = new JFrame("Account");

    JTextField Utext = new JTextField();
    JPasswordField Ptext = new JPasswordField();
    JTextField Etext = new JTextField();
    
    public accountPage() {
      
        
        Facc.setSize(700, 600);
        Facc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Facc.setLocationRelativeTo(null);
        
        Facc.setLayout(null);
        
        JLabel label = new JLabel("Account List");
        label.setBounds(280, 50, 200, 40);
        
        Font font = new Font("Monospace", Font.BOLD, 22);
        label.setFont(font);

        Facc.add(label);
        

        //length of file
        int length = 0;
        try {
            Scanner sc = new Scanner(new File("account.txt"));
            while(sc.hasNextLine()) {
                length++;
                sc.nextLine();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        Laman = new String[length][3];
        
        int i = 0;
        try {
            Scanner sc = new Scanner(new File("account.txt"));
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(" , ");
                //username password email
                Laman[i][0] = parts[0];
                Laman[i][1] = parts[1];
                Laman[i][2] = parts[2];
                i++;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

       
         model = new DefaultTableModel(Laman, Cnames);
         Lamesa = new JTable(model);
        Lamesa.setBounds(50, 100, 600, 200);
        Facc.add(Lamesa);
       
        JScrollPane scrollPane = new JScrollPane(Lamesa);
        scrollPane.setBounds(50, 100, 600, 200);
        Facc.add(scrollPane);
        
        Lamesa.setRowSelectionAllowed(true);

        
        JLabel addAccount = new JLabel("Add Account");
        addAccount.setBounds(50, 300, 200, 40);
        Facc.add(addAccount);
        addAccount.setFont(font);
       
        JLabel username = new JLabel("Username");
        username.setBounds(50, 350, 100, 40);
        Facc.add(username);

        JLabel password = new JLabel("Password");
        password.setBounds(50, 400, 100, 40);
        Facc.add(password);
      
        JLabel email = new JLabel("Email");
        email.setBounds(50, 450, 100, 40);
        Facc.add(email);

       
        
        Utext.setBounds(150, 350, 200, 40);
        Facc.add(Utext);

        Ptext.setBounds(150, 400, 200, 40);
        Facc.add(Ptext);

        Etext.setBounds(150, 450, 200, 40);
        Facc.add(Etext);


        // all buttons
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(50, 500, 100, 40);
        Facc.add(btnBack);
        btnBack.addActionListener(new back());

        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(250, 500, 100, 40);
        Facc.add(btnUpdate);
        btnUpdate.addActionListener(new update());
        



        
        JButton add = new JButton("Add");
        add.setBounds(400, 500, 100, 40);
        Facc.add(add);
        add.addActionListener(new add());



        
        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(550, 500, 100, 40);
        Facc.add(btnDelete);
        btnDelete.addActionListener(new delete());
    

        Facc.setVisible(true);

        



        
    }
    
    class back implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Facc.dispose();
            new mainMenu();
        }
    }

    class update implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            int i = Lamesa.getSelectedRow();
            String username = Utext.getText();
            String password = Ptext.getText();
            String email = Etext.getText();
            if(i == -1 ){
                JOptionPane.showMessageDialog(null, "Please select a row to update");
            }
            else{
                if(!username.isEmpty() && !password.isEmpty() && !email.isEmpty()){
                                if(i >= 0) {
                                    model.setValueAt(username, i, 0);
                                    model.setValueAt(password, i, 1);
                                    model.setValueAt(email, i, 2);
                                    try {
                                        FileWriter fileWriter = new FileWriter("account.txt");
                                        for(int j = 0; j < Lamesa.getRowCount(); j++) {
                                            fileWriter.write(model.getValueAt(j, 0).toString() + " , " + model.getValueAt(j, 1).toString() + " , " + model.getValueAt(j, 2).toString() + "\n");
                                        }
                                        fileWriter.close();
                                        JOptionPane.showMessageDialog(null, "Update Successful");
                                      
                                    } catch (IOException e1) {
                                        e1.printStackTrace();
                                    }
                                }

                }else{
                    JOptionPane.showMessageDialog(null, "Please fill in all the fields");
                }
            }
            

            

        }
    }

    class add implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           
            String username = Utext.getText();
            String password = Ptext.getText();
            String email = Etext.getText();
            
        if(!username.isEmpty() && !password.isEmpty() && !email.isEmpty()){
            
                        try{
                        File file = new File("account.txt");
                        FileWriter fileWriter = new FileWriter(file,true);
                        fileWriter.write(username + " , " + password + " , " + email+ "\n");
                        JOptionPane.showMessageDialog(null, "Add account Successful");
                        fileWriter.close();
                        Facc.dispose();
                        new accountPage();
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    Utext.setText("");
                    Ptext.setText("");
                    Etext.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Please fill in all the fields");
        }

        }
    }
  
    class delete implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            int row = Lamesa.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row to delete");
                }else {
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this account?", "Delete", JOptionPane.YES_NO_OPTION);
                    if(confirm == JOptionPane.YES_OPTION) {
                        model.removeRow(row);
                        try {
                            BufferedWriter bw = new BufferedWriter(new FileWriter("account.txt"));
                            for(int i = 0; i < Lamesa.getRowCount(); i++) {
                                for(int j = 0; j < Lamesa.getColumnCount(); j++) {
                                    bw.write(Lamesa.getValueAt(i, j).toString() + " , ");
                                }
                                bw.newLine();
                            }
                            bw.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
        }
    }



    
    
}

