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
public class UserDTOTest {
    
    public UserDTOTest() {
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
    public void testGetUserID() {
        System.out.println("getUserID");
        UserDTO instance = new UserDTO();
        String expResult = null;
        String result = instance.getUserID();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetUserID() {
        System.out.println("setUserID");
        String userID = "SE140801";
        UserDTO instance = new UserDTO();
        instance.setUserID(userID);
        String expResult = "SE140801";
        assertEquals(expResult, instance.getUserID());
    }

    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        UserDTO instance = new UserDTO();
        String expResult = null;
        String result = instance.getFullName();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetFullName() {
        System.out.println("setFullName");
        String fullName = "LE NHU";
        UserDTO instance = new UserDTO();
        instance.setFullName(fullName);
        String expResult = "LE NHU";
        assertEquals(expResult, instance.getFullName());
    }

    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        UserDTO instance = new UserDTO();
        String expResult = null;
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "05112000";
        UserDTO instance = new UserDTO();
        instance.setPassword(password);
        String expResult = "05112000";
        assertEquals(expResult, instance.getPassword());
    }

    @Test
    public void testIsStatus() {
        System.out.println("isStatus");
        UserDTO instance = new UserDTO();
        boolean expResult = false;
        boolean result = instance.isStatus();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        boolean status = true;
        UserDTO instance = new UserDTO();
        instance.setStatus(status);
        boolean expResult = true;
        assertEquals(expResult, instance.isStatus());
    }
    
}
