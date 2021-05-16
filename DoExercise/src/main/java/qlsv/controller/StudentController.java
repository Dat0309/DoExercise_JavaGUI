/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import qlsv.entity.Studen;
import qlsv.view.StudentView;

/**
 *
 * @author ADMIN
 */
public class StudentController {
    private StudentView studentView;

    public StudentController(StudentView studentView) {
        this.studentView = studentView;
        
        
    }
    
    public void ShowStudentView(){
       studentView.setVisible(true);
    }
    
     class AddStudentListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
           Studen student = studentView.getStudentInfo();
           if(student !=null){
               studentView.showStudentInfo(student);
               //studentView.showListStudent(list);
               studentView.showMessage("Success");
           }
        }
    }
     
     
    
}
