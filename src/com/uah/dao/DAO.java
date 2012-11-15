package com.uah.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Pablo Sicilia
 * @version Mavsel Tool 1.0
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
