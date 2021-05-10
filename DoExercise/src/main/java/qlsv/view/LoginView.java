/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import qlsv.entity.User;

/**
 *
 * @author ADMIN
 */
public class LoginView extends JFrame implements ActionListener{
    
    private static final long serialVersionUID=1L;
    private JLabel lbUserName;
    private JLabel lbPassword;
    private JPasswordField pass;
    private JTextField txtuser;
    private JButton login;

    public LoginView() {
        initUI();
    }
    
    private final void initUI(){
        lbUserName= new JLabel("UserName: ");
        lbPassword= new JLabel("PassWord: ");
        pass= new JPasswordField(15);
        txtuser= new JTextField(15);
        login= new JButton("Login");
        login.addActionListener(this);
        
        //Tạo spring layout
        //SpringLayout tạo ra bố cục chứa các khoảng cách ngang dọc giữa hai thành phần, hiểu cách khác, SpringLayout tạo ra bố cục của các cửa số login
        SpringLayout layout = new SpringLayout();
        
        //Đối tượng panel để chứa các component thành phần
        JPanel panel= new JPanel();
        panel.setSize(500,500);
        panel.setLayout(layout);
        panel.add(lbUserName);
        panel.add(txtuser);
        panel.add(lbPassword);
        panel.add(pass);
        panel.add(login);
        
        //Cài đặt vị trí các component trên màn hình login
        layout.putConstraint(SpringLayout.WEST,lbUserName, 20,SpringLayout.WEST , panel);
        layout.putConstraint(SpringLayout.NORTH, lbUserName, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, lbPassword, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, lbPassword, 105, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, txtuser, 80, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtuser, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST,pass , 80, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, pass, 105, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, login, 80, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, login, 130, SpringLayout.NORTH, panel);
        
        add(panel);
        pack();
        
        setTitle("Login");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
    
    public User getUser(){
        return  new User(txtuser.getText(),String.copyValueOf(pass.getPassword()));
    }
    
    public void addLoginLisener(ActionListener e){
        login.addActionListener( e);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
