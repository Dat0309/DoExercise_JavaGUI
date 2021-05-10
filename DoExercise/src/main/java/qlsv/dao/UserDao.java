/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv.dao;

import qlsv.entity.User;

/**
 *
 * @author ADMIN
 */
public class UserDao {
    public boolean checkUser(User user){
        if(user!=null){
            if("dat09".equals(user.getUsername())&& "1".equals(user.getPassword()))
                return true;
        }
        return false;
    }
}
