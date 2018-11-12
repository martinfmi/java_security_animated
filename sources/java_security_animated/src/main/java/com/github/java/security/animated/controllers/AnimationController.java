package com.github.java.security.animated.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.github.java.security.animated.AnimationManager;

public class AnimationController implements ActionListener {

	private BaseController baseController;
	
	public AnimationController(BaseController baseController) {
		this.baseController = baseController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		AnimationManager.getInstance().animate(baseController);
		baseController.getDisplayPanel().addPlayButtons();
	}
	
}
