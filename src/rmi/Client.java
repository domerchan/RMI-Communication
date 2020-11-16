/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import java.util.Scanner;

/**
 *
 * @author Domenica
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        // TODO code application logic here
        
        //CLIENTE 
        // localiza el stub y usa su interfaz
        
        /* Modos de buscar el stub de un servicio 
    
        Mediante java.rmi.registry.Registry
            Registry registro=LocateRegistry.getRegistry();
            registro.lookup(nombre);
        Mediante java.rmi.Naming
            Naming.lookup(nombre)
        
        */
        Interface service = (Interface) Naming.lookup("rmi://localhost:1234/hello");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar primer valor");
        int a = sc.nextInt();
        System.out.println("Ingresar segundo valor");
        int b = sc.nextInt();
        System.out.println(service.add(a, b));
    }
    
}
