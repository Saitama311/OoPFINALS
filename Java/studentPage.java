import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.Font;

public class studentPage {
    JFrame FrameStudent = new JFrame("Student Information");
    
    JTextField textStudentID = new JTextField(20);
    JTextField textStudentName = new JTextField(20);
    JTextField textAge = new JTextField(20);
    
  
    
    JComboBox comboGender;
    JComboBox comboCourse;
    JComboBox comboYear;
    JTextField textAverageGrade = new JTextField(20);
    JTextField textAddress = new JTextField(20);
    JTextField textContactNumber = new JTextField(20);
    
    DefaultTableModel model;
    JTable table;


    public studentPage(){
        FrameStudent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        FrameStudent.setLayout(null);
        FrameStudent.setSize(1200, 500);
        Font font = new Font("Arial", Font.BOLD, 14);


        JLabel labelStudent = new JLabel("Student Information");
        labelStudent.setBounds(100, 10, 140, 25);
        FrameStudent.add(labelStudent);
        labelStudent.setFont(font);

      
        JLabel labelStudentID = new JLabel("Student ID");
        labelStudentID.setBounds(10, 50, 80, 25);
        FrameStudent.add(labelStudentID);

       
        textStudentID.setBounds(100, 50, 165, 25);
        FrameStudent.add(textStudentID);

     
        JLabel labelStudentName = new JLabel("Student Name");
        labelStudentName.setBounds(10, 80, 80, 25);
        FrameStudent.add(labelStudentName);

        textStudentName.setBounds(100, 80, 165, 25);
        FrameStudent.add(textStudentName);

       
        JLabel labelAge = new JLabel("Age");
        labelAge.setBounds(10, 110, 80, 25);
        FrameStudent.add(labelAge);

        
        textAge.setBounds(100, 110, 165, 25);
        FrameStudent.add(textAge);

        JLabel labelGender = new JLabel("Gender");
        labelGender.setBounds(10, 140, 80, 25);
        FrameStudent.add(labelGender);

       
        String gender[] = {"Male","Female"};
        comboGender = new JComboBox(gender);
        comboGender.setBounds(100, 140, 165, 25);
        FrameStudent.add(comboGender);

        JLabel labelCourse = new JLabel("Course");
        labelCourse.setBounds(10, 170, 80, 25);
        FrameStudent.add(labelCourse);
      
        String courses = "BSIT,BSCS,BSBA,BSA,BSHM,BACOMM,BMMA,BSTM,other";
        String[] course = courses.split(",");
        comboCourse = new JComboBox(course);
       
        comboCourse.setBounds(100, 170, 165, 25);
        FrameStudent.add(comboCourse);

        
        JLabel labelYearLevel = new JLabel("Year Level");
        labelYearLevel.setBounds(10, 200, 80, 25);
        FrameStudent.add(labelYearLevel);

        String yearLevel = "1st Year,2nd Year,3rd Year,4th Year,5th Year";
        String[] year = yearLevel.split(",");
        comboYear = new JComboBox(year);
        comboYear.setBounds(100, 200, 165, 25);
        FrameStudent.add(comboYear);

      
        JLabel labelAverageGrade = new JLabel("Average Grade");
        labelAverageGrade.setBounds(10, 230, 90, 25);
        FrameStudent.add(labelAverageGrade);

       
        textAverageGrade.setBounds(100, 230, 165, 25);
        FrameStudent.add(textAverageGrade);

    
        JLabel labelAddress = new JLabel("Address");
        labelAddress.setBounds(10, 260, 80, 25);
        FrameStudent.add(labelAddress);

        
        textAddress.setBounds(100, 260, 165, 25);
        FrameStudent.add(textAddress);

        JLabel labelContactNumber = new JLabel("Contact No.");
        labelContactNumber.setBounds(10, 290, 90, 25);
        FrameStudent.add(labelContactNumber);

        
        textContactNumber.setBounds(100, 290, 165, 25);
        FrameStudent.add(textContactNumber);
         
        JLabel labelTable = new JLabel("Student Information");
        labelTable.setBounds(300, 10, 150, 30);
        FrameStudent.add(labelTable);
        labelTable.setFont(font);


        int length = 0;
        try{
            Scanner sc = new Scanner(new File("student.txt"));
            while(sc.hasNextLine()){
                length++;
                sc.nextLine();
            }
            sc.close();
        }catch(Exception e){
            System.out.println("Error");
        }

        String data[][] = new String[length][9];

        String column[] = {"Student ID", "Student Name", "Age", "Gender", "Course", "Year Level", "Average Grade", "Address", "Contact Number"};

        int i = 0;
        try{
            Scanner sc = new Scanner(new File("student.txt"));
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] data1 = line.split(",");
                data[i][0] = data1[0];
                data[i][1] = data1[1];
                data[i][2] = data1[2];
                data[i][3] = data1[3];
                data[i][4] = data1[4];
                data[i][5] = data1[5];
                data[i][6] = data1[6];
                data[i][7] = data1[7];
                data[i][8] = data1[8];
                i++;
            }
            sc.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        model = new DefaultTableModel(data, column);
        table = new JTable(model);
        table.setBounds(300, 50, 800, 400);
        FrameStudent.add(table);

        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(300, 50, 800, 400);
        FrameStudent.add(scrollPane);

        table.setRowSelectionAllowed(true);

        JButton buttonAdd = new JButton("Add");
        buttonAdd.setBounds(10, 320, 80, 25);
        FrameStudent.add(buttonAdd);

        JButton buttonUpdate = new JButton("Update");
        buttonUpdate.setBounds(100, 320, 80, 25);
        FrameStudent.add(buttonUpdate);

        JButton buttonDelete = new JButton("Delete");
        buttonDelete.setBounds(190, 320, 80, 25);
        FrameStudent.add(buttonDelete);

        JButton buttonClear = new JButton("Clear");
        buttonClear.setBounds(10, 350, 80, 25);
        FrameStudent.add(buttonClear);

        JButton buttonBack = new JButton("Back");
        buttonBack.setBounds(100, 350, 80, 25);
        FrameStudent.add(buttonBack);

        FrameStudent.setVisible(true);

        buttonAdd.addActionListener(new AddButton());
        buttonUpdate.addActionListener(new UpdateButton());
        buttonDelete.addActionListener(new DeleteButton());
        buttonClear.addActionListener(new ClearButton());
        buttonBack.addActionListener(new BackButton());
        
        
    }
    
    public class AddButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int x = table.getSelectedRow();
            String studentID = textStudentID.getText();
            String studentName = textStudentName.getText();
            String age = textAge.getText();
            String sex = comboGender.getSelectedItem().toString();
            String course = comboCourse.getSelectedItem().toString();
            String yearLevel = comboYear.getSelectedItem().toString();
            String averageGrade = textAverageGrade.getText();
            String address = textAddress.getText();
            String contactNumber = textContactNumber.getText();
            
            if(!studentID.equals("") && !studentName.equals("") && !age.equals("")&& !textAverageGrade.equals("") && !address.equals("") && !contactNumber.equals("")){
                                                    try{
                                                        File file = new File("student.txt");
                                                        FileWriter fileWriter = new FileWriter(file,true);
                                                        fileWriter.write(studentID + " , " +studentName+" , "+age+" , "+sex+" , " + course+" , " +yearLevel+" , "+averageGrade+" , " + address + " , " + contactNumber + "\n");
                                                        JOptionPane.showMessageDialog(null, "Added Successful");
                                                        fileWriter.close();
                                                    }catch(Exception ex){ex.printStackTrace();}
                                                        FrameStudent.dispose();
                                                        new studentPage();
        
            }else{JOptionPane.showMessageDialog(null, "Please fill up all the fields");}

        }
    }

   
    public class UpdateButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int x = table.getSelectedRow();
            String studentID = textStudentID.getText();
            String studentName = textStudentName.getText();
            String age = textAge.getText();
            String sex = comboGender.getSelectedItem().toString();
            String course = comboCourse.getSelectedItem().toString();
            String yearLevel = comboYear.getSelectedItem().toString();
            String averageGrade = textAverageGrade.getText();
            String address = textAddress.getText();
            String contactNumber = textContactNumber.getText();
            if(x==-1){
                JOptionPane.showMessageDialog(null, "Please select a row to update");
            }
            else{
                if(!studentID.equals("") && !studentName.equals("") && !age.equals("")&& !textAverageGrade.equals("") && !address.equals("") && !contactNumber.equals("")){
                                                    if(x >= 0) {
                                                        model.setValueAt(studentID, x, 0);
                                                        model.setValueAt(studentName, x, 1);
                                                        model.setValueAt(age, x, 2);
                                                        model.setValueAt(sex, x, 3);
                                                        model.setValueAt(course, x, 4);
                                                        model.setValueAt(yearLevel, x, 5);
                                                        model.setValueAt(averageGrade, x, 6);
                                                        model.setValueAt(address, x, 7);
                                                        model.setValueAt(contactNumber, x, 8);
                                                        try {
                                                            FileWriter fileWriter = new FileWriter("student.txt");
                                                            for(int j = 0; j < table.getRowCount(); j++) {
                                                                fileWriter.write(model.getValueAt(j, 0).toString() + " , " + model.getValueAt(j, 1).toString() + " , " + model.getValueAt(j, 2).toString() + " , " + model.getValueAt(j, 3).toString() + " , " + model.getValueAt(j, 4).toString() + " , " + model.getValueAt(j, 5).toString() + " , " + model.getValueAt(j, 6).toString() + " , " + model.getValueAt(j, 7).toString() + " , " + model.getValueAt(j, 8).toString() + "\n");
                                                            }
                                                            fileWriter.close();
                                                            JOptionPane.showMessageDialog(null, "Update Successful");
                                                           
                                                        } catch (IOException e1) {e1.printStackTrace();}
                                                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Please fill up all the fields");
                }

            }

        }
    }

    
    public class DeleteButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int row = table.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row to delete");
                }else {
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this account?", "Delete", JOptionPane.YES_NO_OPTION);
                    if(confirm == JOptionPane.YES_OPTION) {
                        model.removeRow(row);
                        try {
                            FileWriter fileWriter = new FileWriter("student.txt");
                            for(int j = 0; j < table.getRowCount(); j++) {
                                fileWriter.write(model.getValueAt(j, 0).toString() + " , " + model.getValueAt(j, 1).toString() + " , " + model.getValueAt(j, 2).toString() + " , " + model.getValueAt(j, 3).toString() + " , " + model.getValueAt(j, 4).toString() + " , " + model.getValueAt(j, 5).toString() + " , " + model.getValueAt(j, 6).toString() + " , " + model.getValueAt(j, 7).toString() + " , " + model.getValueAt(j, 8).toString() + "\n");
                            }
                            fileWriter.close();
                            JOptionPane.showMessageDialog(null, "Delete Successful");
                        } catch (IOException e1) {e1.printStackTrace();
                    }
                }
            }
        }
    }

    public class ClearButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            textStudentID.setText("");
            textStudentName.setText("");
            textAge.setText("");
            textAverageGrade.setText("");
            textAddress.setText("");
            textContactNumber.setText("");
        }
    }

    
    public class BackButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            FrameStudent.dispose();
            new mainMenu();
        }
    }
    


}
