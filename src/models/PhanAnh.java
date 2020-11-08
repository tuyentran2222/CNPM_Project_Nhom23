/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoang Trung Hieu
 */
public class PhanAnh {
    Connection conn = MySQLConnection.getMySQLConnection();
    private String name; // ten nguoi phan anh
    private String content; // noi dung phan anh
    private String date; // gnay phan anh
    private String type; // phan loai
    private String state; // trang thai

    public PhanAnh() {
    }

    public PhanAnh(String name, String content, String date, String type, String state) {
        this.name = name;
        this.content = content;
        this.date = date;
        this.type = type;
        this.state = state;
    }
    
    /**
     * @author Hoang Trung Hieu
     */
    public void insertPA() {
        String sqlInsert = "INSERT INTO phan_anh (NGUOI_PHAN_ANH, NOI_DUNG, NGAY_PHAN_ANH, PHAN_LOAI, TRANG_THAI) "
                            + "VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);
            stmt.setString(1, name);
            stmt.setString(2, content);
            stmt.setString(3, date);
            stmt.setString(4, type);
            stmt.setString(5, state);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PhanAnh.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
