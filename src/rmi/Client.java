/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import java.util.Scanner;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 *
 * @author Domenica
 */
public class Client extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField txt_a;
	private JTextField txt_b;
	
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        // TODO code application logic here
        Client ventana = new Client();
        ventana.frame.setVisible(true);
        /*Interface service = (Interface) Naming.lookup("rmi://localhost:1234/hello");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar primer valor");
        int a = sc.nextInt();
        System.out.println("Ingresar segundo valor");
        int b = sc.nextInt();
        System.out.println(service.add(a, b));*/
    }
    
    public Client() {
    	initialize();
    }
    
    private void initialize() {
    	frame = new JFrame();
    	frame.setSize(400, 300);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	Container cp = getContentPane();
    	cp.setLayout(new FlowLayout());
    	JLabel titulo = new JLabel("Operaciones con RMI");
    	JLabel tag_a = new JLabel("a");
    	txt_a = new JTextField(5);
    	JLabel tag_b = new JLabel("b");
    	txt_b = new JTextField(5);
    	JButton btn = new JButton("Sumar");
    	btn.addActionListener(this);
    	cp.add(titulo);
    	cp.add(tag_a);
    	cp.add(txt_a);
    	cp.add(tag_b);
    	cp.add(txt_b);
    	cp.add(btn);
    	frame.add(cp);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Interface service;
		try {
			int a = Integer.parseInt(txt_a.getText());
			int b = Integer.parseInt(txt_b.getText());
			service = (Interface) Naming.lookup("rmi://localhost:1234/hello");
			System.out.println(service.add(a, b));
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}
    
}
