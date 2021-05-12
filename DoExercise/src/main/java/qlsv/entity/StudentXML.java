/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv.entity;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public class StudentXML  {
    //Lưu thông tin danh sach sinh viên với định dạng XML vào file sutent.xml
    private List<Studen>  student;
    
    public List<Studen> getStudent(){
        return student;
    }
    
    public void setStudent(List<Studen> student){
        this.student=student;
    }
}
