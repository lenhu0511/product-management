/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhultc.dtos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dell
 */
public class CategoryDTOTest {
    
    public CategoryDTOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetCategoryID() {
        System.out.println("getCategoryID");
        CategoryDTO instance = new CategoryDTO();
        String expResult = null;
        String result = instance.getCategoryID();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCategoryID() {
        System.out.println("setCategoryID");
        String categoryID = "PV";
        CategoryDTO instance = new CategoryDTO();
        instance.setCategoryID(categoryID);
        String expResult = "PV";
        assertEquals(expResult, instance.getCategoryID());
    }

    @Test
    public void testGetCategoryName() {
        System.out.println("getCategoryName");
        CategoryDTO instance = new CategoryDTO();
        String expResult = null;
        String result = instance.getCategoryName();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCategoryName() {
        System.out.println("setCategoryName");
        String categoryName = "Phong Vu";
        CategoryDTO instance = new CategoryDTO();
        instance.setCategoryName(categoryName);
        String expResult = "Phong Vu";
        assertEquals(expResult, instance.getCategoryName());
    }

    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        CategoryDTO instance = new CategoryDTO();
        String expResult = null;
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "Ha Noi";
        CategoryDTO instance = new CategoryDTO();
        instance.setDescription(description);
        String expResult = "Ha Noi";
        assertEquals(expResult, instance.getDescription());
    }
    
}
