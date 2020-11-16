/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Domenica
 */
public class Service extends UnicastRemoteObject implements Interface{

    // implementa la interfaz del servidor 
    
    //OBJETO REMOTO
    public Service () throws RemoteException{
    super();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Sumando "+a+" + "+b);
        return a+b;
    }
    
}
