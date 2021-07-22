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
public class ProductDTOTest {
    
    public ProductDTOTest() {
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
    public void testGetProductID() {
        System.out.println("getProductID");
        ProductDTO instance = new ProductDTO();
        String expResult = null;
        String result = instance.getProductID();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetProductID() {
        System.out.println("setProductID");
        String productID = "P001";
        ProductDTO instance = new ProductDTO();
        instance.setProductID(productID);
        String expResult = "P001";
        assertEquals(expResult, instance.getProductID());
    }

    @Test
    public void testGetProductName() {
        System.out.println("getProductName");
        ProductDTO instance = new ProductDTO();
        String expResult = null;
        String result = instance.getProductName();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetProductName() {
        System.out.println("setProductName");
        String productName = "Mouse";
        ProductDTO instance = new ProductDTO();
        instance.setProductName(productName);
        String expResult = "Mouse";
        assertEquals(expResult, instance.getProductName());
    }

    @Test
    public void testGetUnit() {
        System.out.println("getUnit");
        ProductDTO instance = new ProductDTO();
        String expResult = null;
        String result = instance.getUnit();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetUnit() {
        System.out.println("setUnit");
        String unit = "block 10";
        ProductDTO instance = new ProductDTO();
        instance.setUnit(unit);
        String expResult = "block 10";
        assertEquals(expResult, instance.getUnit());
    }

    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        ProductDTO instance = new ProductDTO();
        float expResult = 0.0F;
        float result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        float price = 40;
        ProductDTO instance = new ProductDTO();
        instance.setPrice(price);
        float expResult = 40;
        assertEquals(expResult, instance.getPrice(), 40);
    }

    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        ProductDTO instance = new ProductDTO();
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 10;
        ProductDTO instance = new ProductDTO();
        instance.setQuantity(quantity);
        int expResult = 10;
        assertEquals(expResult, instance.getQuantity(), 10);
    }

    @Test
    public void testGetCategoryID() {
        System.out.println("getCategoryID");
        ProductDTO instance = new ProductDTO();
        String expResult = null;
        String result = instance.getCategoryID();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCategoryID() {
        System.out.println("setCategoryID");
        String categoryID = "TT";
        ProductDTO instance = new ProductDTO();
        instance.setCategoryID(categoryID);
        String expResult = "TT";
        assertEquals(expResult, instance.getCategoryID());
    }
    
}
