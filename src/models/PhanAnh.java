/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author Hoang Trung Hieu
 */
public class PhanAnh {
    private int id; // ma phan anh
    private String name; // ten nguoi phan anh
    private String content; // noi dung phan anh
    private Date date; // ngay phan anh
    private String type; // phan loai
    private String state; // trang thai

    public PhanAnh() {
    }

    public PhanAnh(int id, String name, String content, Date date, String type, String state) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.date = date;
        this.type = type;
        this.state = state;
    }

    public PhanAnh(String name, String content, Date date, String type, String state) {
        this.name = name;
        this.content = content;
        this.date = date;
        this.type = type;
        this.state = state;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
    
    
}
