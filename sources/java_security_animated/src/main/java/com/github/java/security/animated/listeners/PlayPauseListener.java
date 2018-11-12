package com.github.java.security.animated.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.github.java.security.animated.AnimationManager;

public class PlayPauseListener implements ActionListener {

	private URL playIconURL;
	private URL pauseIconURL;
	private JButton playPauseButton;

	private boolean paused = false;

	public PlayPauseListener(JButton playPauseButton, URL playIconURL, URL pauseIconURL) {
		this.playIconURL = playIconURL;
		this.pauseIconURL = pauseIconURL;
		this.playPauseButton = playPauseButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (paused) {
			playPauseButton.setIcon(new ImageIcon(pauseIconURL));
			AnimationManager.getInstance().resume();
			paused = false;
		} else {
			playPauseButton.setIcon(new ImageIcon(playIconURL));
			AnimationManager.getInstance().pause();
			paused = true;
		}
	}
	
	public void setPaused(boolean paused) {
		this.paused = paused;
		if(paused) {
			playPauseButton.setIcon(new ImageIcon(playIconURL));
		} else {
			playPauseButton.setIcon(new ImageIcon(pauseIconURL));
		}
	}

}
