/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhultc.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import com.nhultc.dtos.UserDTO;
import com.nhultc.utils.DBHelper;

/**
 *
 * @author Dell
 */
public class UserDAO {
    private Vector<UserDTO> listUsers = new Vector();
    
    public Vector<UserDTO> getAllUsers(){
        return listUsers;
    }
    
    public void loadData() throws Exception{
        Connection con= null;
        PreparedStatement ps = null;
        ResultSet rs= null;
        try{
            con = DBHelper.openConnection();
            if(con != null){
                String sql= "SELECT userID, fullName, password, status FROM dbo.tblUsers";
                ps= con.prepareStatement(sql);
                rs= ps.executeQuery();
                while(rs.next()){
                    UserDTO user= new UserDTO(rs.getString("userID"), rs.getString("fullName"), rs.getString("password"), rs.getBoolean("status"));
                    listUsers.add(user);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
        }           
    }
    
    public boolean checkLogin(String userID, String password){
        for(int i=0; i<listUsers.size();i++){
            if(userID.equals(listUsers.get(i).getUserID())&& password.equals(listUsers.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }
}
