package com.github.java.security.animated.controllers;

import java.awt.Graphics;
import java.awt.event.ActionEvent;

import com.github.java.security.animated.view.MainDisplayPanel;

public class NotImplementedController extends BaseController {

	public NotImplementedController(MainDisplayPanel panel) {
		super(panel);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		super.actionPerformed(e);
		
		Graphics graphics = displayPanel.getGraphics();
		graphics.drawRect(400, 250, 200, 100);
		graphics.drawString("Work in progress ...", 450, 300);
		
	}
	
}
