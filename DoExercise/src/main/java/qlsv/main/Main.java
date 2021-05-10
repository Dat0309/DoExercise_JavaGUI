/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv.main;

import qlsv.controller.LoginController;
import qlsv.view.LoginView;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginView view= new LoginView();
        LoginController controller = new LoginController(view);
        
        controller.showLoginView();
    }
    
}
