/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhultc.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import com.nhultc.dtos.ProductDTO;
import com.nhultc.ui.TableModelProduct;
import com.nhultc.utils.DBHelper;

/**
 *
 * @author Dell
 */
public class ProductDAO {
    private String[] header = {"ProductID", "ProductName", "Unit", "Price","Quantity","CategoryID"};
    private int[] index = {0,1,2,3,4,5};
    private TableModelProduct modelProduct = new TableModelProduct(header, index);
    
    public TableModelProduct getModelProduct(){
        return modelProduct;
    }
    
    public ProductDAO(){
        try {
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadData() throws Exception{
        modelProduct.getList().clear();
        Connection con= null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBHelper.openConnection();
            if(con != null){
                String sql = "SELECT * FROM dbo.tblProducts";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    ProductDTO pro = new ProductDTO(rs.getString("productID"), 
                            rs.getString("productName"), 
                            rs.getString("unit"), 
                            rs.getFloat("price"),
                            rs.getInt("quantity"),
                            rs.getString("categoryID"));
                    modelProduct.getList().add(pro);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        
        } finally{
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
    
    public String loadCategoryIDIntoProduct(String category){
        StringTokenizer stk = new StringTokenizer(category, "-");
        return stk.nextToken();
    }
    
    public int Insert(ProductDTO pro) throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBHelper.openConnection();
            if(con != null){
                String sql = "INSERT dbo.tblProducts VALUES(?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, pro.getProductID());
                ps.setString(2, pro.getProductName());
                ps.setString(3, pro.getUnit());
                ps.setFloat(4, pro.getPrice());
                ps.setInt(5, pro.getQuantity());
                ps.setString(6, pro.getCategoryID());
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(con != null){
                con.close();
            }
            if(ps != null){
                ps.close();
            }
        }
        return -1;
    }
    
    public int Save(ProductDTO pro) throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBHelper.openConnection();
            if(con != null){
                String sql = "UPDATE dbo.tblProducts SET productName= ?, unit= ?, price= ?, quanity= ?, categoryID =? WHERE productID=?";
                ps = con.prepareStatement(sql);
  
                ps.setString(1, pro.getProductName());
                ps.setString(2, pro.getUnit());
                ps.setFloat(3, pro.getPrice());
                ps.setInt(4, pro.getQuantity());
                ps.setString(5, pro.getCategoryID());
                ps.setString(6, pro.getProductID());
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(con != null){
                con.close();
            }
            if(ps != null){
                ps.close();
            }
        }
        return -1;
    }
    
    public int Delete(ProductDTO pro) throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBHelper.openConnection();
            if(con != null){
                String sql = "DELETE FROM dbo.tblProducts WHERE productID=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, pro.getProductID());
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(con != null){
                con.close();
            }
            if(ps != null){
                ps.close();
            }
        }
        return -1;
    }
    
    public boolean validDataProductID(String productID){
        try {
            for(int i = 0; i< modelProduct.getList().size();i++){
                if(modelProduct.getList().get(i).getCategoryID().compareToIgnoreCase(productID)==0){
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public boolean validData(String productID, String productName, String unit,
            String price, String quantity, Object categoryID){
        if(!productID.toUpperCase().matches("[a-zA-Z]{1}[0-9]{3}")){
            JOptionPane.showMessageDialog(null, "Invalid Product ID");
            return false;
        }
        if(productName.isEmpty() || productName.length()>50){
            JOptionPane.showMessageDialog(null, "Invalid Product Name");
            return false;
        }
        if(unit.isEmpty() || productName.length()>50){
            JOptionPane.showMessageDialog(null, "Invalid Unit");
            return false;
        }
        if(price.isEmpty() || !price.matches("\\d+.?\\d*")){
            JOptionPane.showMessageDialog(null, "Invalid Price");
            return false;
        }
        if(quantity.isEmpty() || !quantity.matches("\\d{1,5}")){
            JOptionPane.showMessageDialog(null, "Invalid Quanity");
            return false;
        }
        if(categoryID == null){
            JOptionPane.showMessageDialog(null, "Choose the Category ID");
            return false;
        }
        return true;
    }
    
    public boolean checkCategoryID(String categoryID){
        for(int i=0; i< modelProduct.getList().size();i++){
            if(categoryID.compareToIgnoreCase(modelProduct.getList().get(i).getCategoryID())== 0){
                return false;
            }
        }
        return true;
    }
    
    
    
}
