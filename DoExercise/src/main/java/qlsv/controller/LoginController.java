/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import qlsv.dao.UserDao;
import qlsv.entity.User;
import qlsv.view.LoginView;
import qlsv.view.StudentView;

/**
 *
 * @author ADMIN
 */
public class LoginController {
    private UserDao userdao;
    private LoginView loginview;
    private StudentView studentview;

    public LoginController(LoginView view) {
        this.loginview = view;
        this.userdao= new UserDao();
        view.addLoginLisener(new LoginListener());

    }

    public void showLoginView(){
        loginview.setVisible(true);
    }
    
    //Sự kiện cho nút login.
    public class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User user = loginview.getUser();
            if (userdao.checkUser(user)) {
                // nếu đăng nhập thành công, mở màn hình quản lý sinh viên
                studentview = new StudentView();
                StudentController studentController = new StudentController(studentview);
                studentController.ShowStudentView();
                loginview.setVisible(false);
            } else {
                loginview.showMessage("username hoặc password không đúng.");
                
            }
        }
    }
}
