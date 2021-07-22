/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhultc.ui;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import com.nhultc.dtos.CategoryDTO;

/**
 *
 * @author Dell
 */
public class TableModelCategory extends AbstractTableModel {
    private String[] header;
    private int[] index;
    private Vector<CategoryDTO> data;
    
    public Vector<CategoryDTO> getList(){
        return data;
    }
    
    public TableModelCategory(String[] headers, int[] indexes){
        this.header= new String[headers.length];
        for(int i=0; i<headers.length;i++){
            this.header[i]= headers[i];
        }
        this.index= new int[indexes.length];
        for(int i=0; i<indexes.length; i++){
            this.index[i] = indexes[i];
        }
        data= new Vector<>();
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
        CategoryDTO ca= data.get(rowIndex);
        switch(index[columnIndex]){
            case 0: return ca.getCategoryID();
            case 1: return ca.getCategoryName();
            case 2: return ca.getDescription();
        }
        return null;
    }
    
    
}
