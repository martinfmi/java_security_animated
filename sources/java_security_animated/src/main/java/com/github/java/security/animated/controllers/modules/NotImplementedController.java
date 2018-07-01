package com.github.java.security.animated.controllers.modules;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class NotImplementedController implements ActionListener {

	private JPanel displayPanel;
	
	public NotImplementedController(JPanel displayPanel) {
		this.displayPanel = displayPanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Graphics graphics = displayPanel.getGraphics();
		graphics.drawRect(400, 250, 200, 100);
		graphics.drawString("Work in progress ...", 450, 300);
	}
	
}
