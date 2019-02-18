package com.github.java.security.animated.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.github.java.security.animated.util.Helper;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = -644658116657662883L;

	public MainFrame() {
		super("Java Security Animated");
	}
	
	public void init() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 650);

		Helper.mainFrame = this;
		
		MainDisplayPanel display = new MainDisplayPanel(this);
		display.init();
		
		MainMenuPanel menu = new MainMenuPanel(display);
		menu.init();
		
		getContentPane().add(menu);
		getContentPane().add(display);
		
		addWindowListener(new WindowAdapter( ) {
			 public void windowClosing(WindowEvent e) {
				 // nothing at the moment ...
			 }
			 @Override
			public void windowOpened(WindowEvent var1) {
				super.windowOpened(var1);
				display.createWelcomeScreen();
			}
		 });
		
		setIconImage(ImageIO.read(GraphicsLibrary.class.getResource("/icon.png")));
		setVisible(true);
	}
	
}
