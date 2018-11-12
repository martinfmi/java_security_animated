package com.github.java.security.animated.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.github.java.security.animated.AnimationManager;

public class NextListener implements ActionListener {

	private PlayPauseListener playPauseListener;
	
	public NextListener(PlayPauseListener playPauseListener) {
		this.playPauseListener = playPauseListener;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		playPauseListener.setPaused(false);
		AnimationManager.getInstance().next();
	}
	
}
