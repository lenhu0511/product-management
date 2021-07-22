/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhultc.ui;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import com.nhultc.daos.CategoryDAO;
import com.nhultc.dtos.ProductDTO;

/**
 *
 * @author Dell
 */
public class TableModelProduct extends AbstractTableModel{
    private String[] header;
    private int[] index;
    private Vector<ProductDTO> data;
    CategoryDAO dao= new CategoryDAO();
    
    public void loadCategoriesComboBox(){
        try{
            dao.loadAllList();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public String getCategories(String categoryID){
        for(String ca : dao.getAllList()){
            if(ca.contains(categoryID)){
                return ca;
            }
        }
        return "";
    }
    
    public Vector<ProductDTO> getList(){
        return data;
    }
    
    public TableModelProduct(String[] headers, int[] indexes){
        this.header= new String[headers.length];
        for(int i=0; i<headers.length; i++){
            this.header[i]= headers[i];
        }
        this.index= new int[indexes.length];
        for(int i=0; i<indexes.length; i++){
            this.index[i]= indexes[i];
        }
        data= new Vector<>();
    }

    @Override
    public String getColumnName(int column) {
        if(column>=0 || column<header.length){
            return header[column];
        }
        else return "";
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(rowIndex<0 || rowIndex>=data.size() || columnIndex<0 || columnIndex>=header.length){
            return null;
        }
        ProductDTO pro= data.get(rowIndex);
        switch(index[columnIndex]){
            case 0: return pro.getProductID();
            case 1: return pro.getProductName();
            case 2: return pro.getUnit();
            case 3: return pro.getQuantity();
            case 4: return pro.getPrice();
            case 5: return pro.getCategoryID();
        }
        return null;
    }
    
}
