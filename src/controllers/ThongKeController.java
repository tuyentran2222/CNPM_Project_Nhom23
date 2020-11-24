/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.PhanAnh;
import service.MySQLConnection;

/**
 *
 * @author ADMIN
 */
public class ThongKeController {
    
    public static long tongPhanAnh(String trangThai, String qui, String tuNam, String denNam, String linhVuc){
        long result = 0;
        try {
            
            Connection connection = MySQLConnection.getMySQLConnection();
            String GET_SUM_SQL = "SELECT COUNT(*) AS tong FROM phan_anh "
                    + "WHERE (trang_thai = ? OR trang_thai = ?) "
                    + "AND MONTH(ngay_phan_anh) >= ? AND MONTH(ngay_phan_anh) <= ?"
                    + "AND YEAR(ngay_phan_anh) >= ? AND YEAR(ngay_phan_anh) <= ? "
                    + "AND phan_loai = ?";
            PreparedStatement statement = connection.prepareStatement(GET_SUM_SQL);
            if(trangThai.equals("Toàn bộ")) {
                statement.setString(1, "Đang giải quyết");
                statement.setString(2, "Đã giải quyết");
            }
            else {
                statement.setString(1, trangThai);
                statement.setString(2, "");
            }
            
            switch(qui){
                case "I" :
                    statement.setString(3, "1");
                    statement.setString(4, "3");
                    break;
                case "II" :
                    statement.setString(3, "4");
                    statement.setString(4, "6");
                    break;
                case "III" :
                    statement.setString(3, "7");
                    statement.setString(4, "9");
                    break;
                case "IV" :
                    statement.setString(3, "10");
                    statement.setString(4, "12");
                    break;
                    
                default :
                    statement.setString(3, "1");
                    statement.setString(4, "12");
                    break;
            }
            
            statement.setString(5, tuNam);
            statement.setString(6, denNam);
            statement.setString(7, linhVuc);
            
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                result = rs.getLong("tong");
            }
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
   public static List<PhanAnh> getListPhanAnh(String trangThai, String qui, String tuNam, String denNam, String linhVuc){
        List<PhanAnh> list = new ArrayList<PhanAnh>();
        try {
            
            Connection connection = MySQLConnection.getMySQLConnection();
            String GET_SUM_SQL = "SELECT ngay_phan_anh, nguoi_phan_anh, noi_dung, phan_loai, trang_thai FROM phan_anh "
                    + "WHERE (trang_thai = ? OR trang_thai = ?) "
                    + "AND MONTH(ngay_phan_anh) >= ? AND MONTH(ngay_phan_anh) <= ?"
                    + "AND YEAR(ngay_phan_anh) >= ? AND YEAR(ngay_phan_anh) <= ? "
                    + "AND phan_loai = ?";
            PreparedStatement statement = connection.prepareStatement(GET_SUM_SQL);
            if(trangThai.equals("Toàn bộ")) {
                statement.setString(1, "Đang giải quyết");
                statement.setString(2, "Đã giải quyết");
            }
            else {
                statement.setString(1, trangThai);
                statement.setString(2, "");
            }
            
            switch(qui){
                case "I" :
                    statement.setString(3, "1");
                    statement.setString(4, "3");
                    break;
                case "II" :
                    statement.setString(3, "4");
                    statement.setString(4, "6");
                    break;
                case "III" :
                    statement.setString(3, "7");
                    statement.setString(4, "9");
                    break;
                case "IV" :
                    statement.setString(3, "10");
                    statement.setString(4, "12");
                    break;
                    
                default :
                    statement.setString(3, "1");
                    statement.setString(4, "12");
                    break;
            }
            
            statement.setString(5, tuNam);
            statement.setString(6, denNam);
            statement.setString(7, linhVuc);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                PhanAnh phanAnh =  new PhanAnh();
                
                phanAnh.setName(rs.getString("nguoi_phan_anh"));
                phanAnh.setContent(rs.getString("noi_dung"));
                phanAnh.setDate(rs.getDate("ngay_phan_anh"));
                phanAnh.setState(rs.getString("trang_thai"));
                phanAnh.setType(rs.getString("phan_loai"));
                
                list.add(phanAnh);
            }
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return list;
    }
}
