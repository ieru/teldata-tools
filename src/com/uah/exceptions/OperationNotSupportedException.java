package com.uah.exceptions;

/**
 *
 * @author Pablo Sicilia
 * @version Mavsel Tool 1.0
 */
public class OperationNotSupportedException  extends Exception{
    
    /**
     * 
     * @param message 
     */
    public OperationNotSupportedException(String message){
        super(message);
    }
}
