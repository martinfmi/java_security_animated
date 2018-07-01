package com.github.java.security.animated.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = -644658116657662883L;

	public MainFrame() {
		super("Java Security Animated");
	}
	
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);

		MainDisplayPanel display = new MainDisplayPanel();
		display.init();
		
		MainMenuPanel menu = new MainMenuPanel(display);
		menu.init();
		
		getContentPane().add(menu);
		getContentPane().add(display);
		
		addWindowListener(new WindowAdapter( ) {
			 public void windowClosing(WindowEvent e) {
				 // nothing at the moment ...
			 }
		 });
		
		setVisible(true);
	}

	
	
}
