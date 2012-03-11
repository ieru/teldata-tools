/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Pablo
 */
public class DAO {
    /**************************************************************************
    *                              ATTRIBUTES
    **************************************************************************/
    protected Statement statement;
    protected ResultSet rs;
    protected static Connection connection;
    
    
    /**************************************************************************
    *                              PUBLIC METHODS
    ***************************************************************************/
    public DAO(Connection connection){
        this.connection = connection;        
    }
}
