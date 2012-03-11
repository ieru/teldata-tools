/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uah.commons;

import com.uah.exceptions.ConnectionParametersException;

/**
 *
 * @author Pablo
 */
public class DataBaseConnectionParameters {
    /**************************************************************************
    *                              ATTRIBUTES
    **************************************************************************/
    private String dataBaseURL;
    private String dataBasePort;
    private String dataBaseName;
    private String dataBaseUser;
    private String dataBaseUserPass;

    
    
    /**************************************************************************
    *                              PUBLIC METHODS
    ***************************************************************************/
    
    /**
     * Constructor
     */   
    public DataBaseConnectionParameters(String dataBaseURL, String dataBasePort, 
            String dataBaseName, String dataBaseUser, String dataBaseUserPass){
        this.dataBaseURL = dataBaseURL;
        this.dataBasePort = dataBasePort;
        this.dataBaseName = dataBaseName;
        this.dataBaseUser = dataBaseUser;
        this.dataBaseUserPass = dataBaseUserPass; 
        
    }

    
    
    /**
     * 
     * @throws ConnectionParametersException 
     */
    public void checkParams() throws ConnectionParametersException{
        if (dataBaseName.isEmpty()){
            throw new ConnectionParametersException("dataBaseName can not be empty.");
        }        
        if (dataBasePort.isEmpty()){
            throw new ConnectionParametersException("dataBasePort can not be empty.");
        }
        if (dataBaseURL.isEmpty()){
            throw new ConnectionParametersException("dataBaseURL can not be empty.");
        }
        if (dataBaseUser.isEmpty()){
            throw new ConnectionParametersException("dataBaseUser can not be empty.");
        }
        if (dataBaseUserPass.isEmpty()){
            throw new ConnectionParametersException("dataBaseUserPass can not be empty.");
        }
    }
       
    
    /**************************************************************************
    *                              Getters
    ***************************************************************************/
    public String getDataBaseName() {
        return dataBaseName;
    }

    public String getDataBasePort() {
        return dataBasePort;
    }

    public String getDataBaseURL() {
        return dataBaseURL;
    }

    public String getDataBaseUser() {
        return dataBaseUser;
    }

    public String getDataBaseUserPass() {
        return dataBaseUserPass;
    }  
      

}
