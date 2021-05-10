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

/**
 *
 * @author ADMIN
 */
public class LoginController {
    private UserDao userdao;
    private LoginView loginview;

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
                //studentView = new StudentView();
                //StudentController studentController = new StudentController(studentView);
                //studentController.showStudentView();
                loginview.showMessage("Đăng nhập thành công");
                loginview.setVisible(false);
            } else {
                loginview.showMessage("username hoặc password không đúng.");
            }
        }
    }
}
