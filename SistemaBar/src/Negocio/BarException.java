/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author 00161615
 */
public class BarException extends Exception{
    
     public BarException(Throwable cause) {
        super(cause);
    }

    public BarException(String message, Throwable cause) {
        super(message, cause);
    }

    public BarException(String message) {
        super(message);
    }

    public BarException() {
    }
    
}
