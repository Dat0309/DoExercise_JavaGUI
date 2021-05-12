/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv.entity;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Studen implements Serializable {
    //Class student lưu trữ thông tin sinh viên
    private static final long serializableUID=1L;
    private int id;
    private String name;
    private byte age;
    private String address;
    private float dtb;

    public Studen() {
    }

    public Studen(int id, String name, byte age, String address, float dtb) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.dtb = dtb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getDtb() {
        return dtb;
    }

    public void setDtb(float dtb) {
        this.dtb = dtb;
    }
    
    
}
