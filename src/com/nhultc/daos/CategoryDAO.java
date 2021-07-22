/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhultc.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.nhultc.dtos.CategoryDTO;
import com.nhultc.ui.TableModelCategory;
import com.nhultc.utils.DBHelper;

/**
 *
 * @author Dell
 */
public class CategoryDAO {
    private String[] header={"Category ID", "Category Name", "Description"};
    private int[] index={0,1,2};
    private TableModelCategory model= new TableModelCategory(header, index);
    private Vector<String> list= new Vector();
    
    public TableModelCategory getModelCategory(){
        return model;
        
    }
    
    public CategoryDAO(){
        try {
            loadAllList();
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Vector<String> loadAllList() throws Exception{
        list.clear();
        Connection conn= null;
        PreparedStatement preStm= null;
        ResultSet rs= null;
        
        try {
            conn= DBHelper.openConnection();
            if(conn != null){
                String sql= "SELECT categoryID, categoryName FROM dbo.tblCategories";
                preStm= conn.prepareStatement(sql);
                rs= preStm.executeQuery();
                while(rs.next()){
                    list.add(rs.getString("categoryID")+" - "+rs.getString("categoryName"));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if(rs != null){
                rs.close();
            }
            if(preStm != null){
                preStm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return null;
    }

    public Vector<String> getAllList() {
        return list;
    }
    
    public String getCategoryNameComboBox(String categoryID){
        for(CategoryDTO ca : model.getList()){
            if(ca.getCategoryID().compareToIgnoreCase(categoryID)==0){
                return ca.getCategoryName();
            }
        }
        return "";
    }
    
    public void loadData() throws Exception{
        model.getList().clear();
        Connection conn= null;
        PreparedStatement preStm= null;
        ResultSet rs= null;
        try {
            conn= DBHelper.openConnection();
            if(conn != null){
                String sql= "SELECT categoryID, categoryName, description FROM dbo.tblCategories";
                preStm= conn.prepareStatement(sql);
                rs= preStm.executeQuery();
                while(rs.next()){
                    CategoryDTO ca= new CategoryDTO(rs.getString("categoryID"), rs.getString("categoryName"), rs.getString("description"));
                    model.getList().add(ca);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if(rs != null){
                rs.close();
            }
            if(preStm != null){
                preStm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
    }
    
    public int InsertCategory(CategoryDTO ca) throws Exception{
        Connection conn= null;
        PreparedStatement preStm= null;
        try {
            conn= DBHelper.openConnection();
            if(conn != null){
                String sql= "Insert dbo.tblCategories Values(?,?,?)";
                
                preStm= conn.prepareStatement(sql);
                preStm.setString(1, ca.getCategoryID());
                preStm.setString(2, ca.getCategoryName());                
                preStm.setString(3, ca.getDescription());
                return preStm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if(conn != null){
                conn.close();
            }
            if(preStm != null){
                preStm.close();
            }            
        }
        return -1;
    }
    
    public int SaveCategory(CategoryDTO ca) throws Exception{
        Connection con= null;
        PreparedStatement preStm= null;
        try {
            con= DBHelper.openConnection();
            if(con != null){
                String sql= "Update dbo.tblCategories Set categoryName=?, description=? Where categoryID=?";
                preStm= con.prepareStatement(sql);
                preStm.setString(1, ca.getCategoryName());
                preStm.setString(2, ca.getDescription());
                preStm.setString(3, ca.getCategoryID());
                return preStm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if(preStm != null){
                preStm.close();
            }
            if(con != null){
                con.close();
            }           
        }
        return -1;
    }
    
    public int DeleteCategory(CategoryDTO ca) throws Exception{
        Connection con= null;
        PreparedStatement preStm= null;
        try {
            con= DBHelper.openConnection();
            if(con != null){
                String sql= "DELETE FROM dbo.tblCategories WHERE categoryID = ?";
                preStm= con.prepareStatement(sql);
                preStm.setString(1, ca.getCategoryID());
                return preStm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if(preStm != null){
                preStm.close();
            }
            if(con != null){
                con.close();
            }           
        }
        return -1;
    }
    
    public boolean validDataCategoryID(String categoryID){
        try {
            for(int i=0; i<model.getList().size(); i++){
                if(model.getList().get(i).getCategoryID().compareToIgnoreCase(categoryID)==0){
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public boolean validData(String categoryID, String categoryName, String description){
        if(!categoryID.toUpperCase().matches("[a-zA-Z]{2}")){
            JOptionPane.showMessageDialog(null, "Invalid Category ID");
            return false;
        }
        if(categoryName.isEmpty() || categoryName.length()>50){
            JOptionPane.showMessageDialog(null, "Invalid Category Name");
            return false;
        }
        if(description.isEmpty() || description.length()>200){
            JOptionPane.showMessageDialog(null, "Invalid Description");
            return false;
        }
        return true;
    }

   
   
}
