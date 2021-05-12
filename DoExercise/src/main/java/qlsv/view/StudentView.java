/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import qlsv.entity.Studen;

/**
 *
 * @author ADMIN
 */
public class StudentView extends JFrame implements ActionListener, ListSelectionListener{

    private static final long serialVersionUID=1L;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnClear;
    private JButton btnSortName;
    private JButton btnSortDTB;
    private JScrollPane scrollPaneStudentTable;
    private JScrollPane scrollPaneADDress;
    private JTable studentTable;
    
    private JLabel lbID;
    private JLabel lbName;
    private JLabel lbAge;
    private JLabel lbAddress;
    private JLabel lbDTB;
    
    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextArea addressArea;
    private JTextField dtbField;
    
    //Định nghĩa các cột của bảng student
    private String[] columnNames= new String[]{
                "ID","Name","Age","Address","DTB"
            };
    
    //Định nghĩa dữ liệu mặc địnhc ảu bảng student là rỗng
    private Object data= new Object [][]{};

    public StudentView() {
        initUI();
    }
    
    private final void initUI(){
        //Khởi tạo các phím chức năng
        btnAdd= new JButton("Add Student");
        btnEdit= new JButton("Edit Student");
        btnDelete= new JButton("Delete Student");
        btnClear= new JButton("Clear Student");
        btnSortName= new JButton("Sort By Name");
        btnSortDTB= new JButton("Sort By DTB");
        
        //Khởi tạo bảng student
        scrollPaneStudentTable = new JScrollPane();
        studentTable= new JTable();
        
        //khởi tạo các Label
        lbID= new JLabel("ID");
        lbName= new JLabel("Name");
        lbAge= new JLabel("Age");
        lbAddress= new JLabel("Address");
        lbDTB= new JLabel("DTB");
        
        //Khởi tạo các trường nhập dữ liệu cho student
        idField= new JTextField(6);
        idField.setEditable(false);
        nameField= new JTextField(15);
        ageField= new JTextField(6);
        addressArea= new JTextArea();
        addressArea.setColumns(15);
        addressArea.setRows(5);
        scrollPaneADDress= new JScrollPane();
        scrollPaneADDress.setViewportView(addressArea);
        dtbField= new JTextField(6);
        
        //Cài đặt các cột và data cho bảng Student
        studentTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        scrollPaneStudentTable.setViewportView(studentTable);
        scrollPaneStudentTable.setPreferredSize(  new Dimension(480,300));
        
        //Tạo spring layout
        SpringLayout layout= new SpringLayout();
        //Đối tượng panel chứa các thành phần màn hình quản lý sinh viên
        JPanel panel= new JPanel();
        panel.setSize(800,420);
        panel.setLayout(layout);
        panel.add(scrollPaneStudentTable);
        
        panel.add(btnAdd);
        panel.add(btnEdit);
        panel.add(btnClear);
        panel.add(btnDelete);
        panel.add(btnSortName);
        panel.add(btnSortDTB);
        
        panel.add(lbID);
        panel.add(lbName);
        panel.add(lbAge);
        panel.add(lbAddress);
        panel.add(lbDTB);
        
        panel.add(idField);
        panel.add(nameField);
        panel.add(ageField);
        panel.add(addressArea);
        panel.add(dtbField);
        
        //Cài đặt vị trí xuất hiện trên màn hình login
        layout.putConstraint(SpringLayout.WEST, lbID, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, lbID, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, lbName, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, lbName, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, lbAge, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, lbAge, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, lbAddress, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, lbAddress, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, lbDTB, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.WEST, lbDTB, 150, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageField, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressArea, 200, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressArea, 200, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, dtbField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, dtbField, 100, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, scrollPaneStudentTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, scrollPaneStudentTable, 10, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, btnAdd, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, lbID, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, btnEdit, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, btnEdit, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, btnClear, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, btnDelete, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, btnDelete, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, btnClear, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, btnSortName, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, btnSortName, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, btnSortDTB, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, btnSortDTB, 10, SpringLayout.NORTH, panel);
        
        add(panel);
        pack();
        setTitle("Student Infomation");
        setSize(800,420);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        btnAdd.setEnabled(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
    
    //Hiển thị list student vào bảng student table
    public void showListStudent(List<Studen> list){
        int size=list.size();
        /*
         Bảng student có 5 cột
        Khởi tạo mảng 2 chiều student, trong đó:
        số hàng là kích thước của list student
        số cột là 5
        */
        Object [][] students= new Object[size][5];
        for(int i=0; i<size;i++){
            students[i][0]=list.get(i).getId();
            students[i][1]=list.get(i).getName();
            students[i][2]=list.get(i).getAge();
            students[i][3]=list.get(i).getAddress();
            students[i][4]=list.get(i).getDtb();
        }
        studentTable.setModel(new DefaultTableModel(students,columnNames));
        
    }
    
    //Điền thông tin của các bảng được chọn vào bảng student
    public void fillStudentFromSelectedRow(){
        //Lấy chỉ số của hàng được chọn
        int row= studentTable.getSelectedRow();
        if(row>=0){
            idField.setText(studentTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(studentTable.getModel().getValueAt(row, 1).toString());
            ageField.setText(studentTable.getModel().getValueAt(row, 2).toString());
            addressArea.setText(studentTable.getModel().getValueAt(row, 3).toString());
            dtbField.setText(studentTable.getModel().getValueAt(row, 4).toString());
            
            //Enable button Edit and button Delete
            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);
            //Disable button Add
            btnAdd.setEnabled(false);
        }
    }
    
    
    //Chức năng xóa thông tin student
    public void clearStudentInfo(){
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        addressArea.setText("");
        dtbField.setText("");
        
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        btnAdd.setEnabled(true);
    }
    
    //Hiển thị thông tin student
    public void showStudentInfo(Studen student){
        idField.setText(""+student.getId());
        nameField.setText(student.getName());
        ageField.setText(""+student.getAge());
        addressArea.setText(student.getAddress());
        dtbField.setText(""+student.getDtb());
        
        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
        btnAdd.setEnabled(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
