
package com.github.java.security.animated.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.github.java.security.animated.listeners.NextListener;
import com.github.java.security.animated.listeners.PlayPauseListener;
import com.github.java.security.animated.listeners.PrevListener;

public class MainDisplayPanel extends JPanel {

	private static final Logger LOGGER = Logger.getLogger(MainDisplayPanel.class.getName());
	
	private static final long serialVersionUID = 7152655695689456552L;

	private boolean animationButtonsAdded = false;

	private JPanel animationButtonsPanel;

	URL playIconURL;
	
	URL pauseIconURL;
	
	URL prevIconURL;
	
	URL nextIconURL;
	
	public void init() {
		setSize(550, 600);
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());

		createAnimationButtons();
	}
	
	public void createWelcomeScreen() {
		Graphics graphics = getGraphics();
		graphics.setFont(new Font("Arial", Font.BOLD, 30)); 
		graphics.drawString("Java Security Animated", 350, 200);
		graphics.setFont(new Font("Arial", Font.PLAIN, 15)); 
		graphics.setColor(Color.GRAY);
		graphics.drawString("Martin Toshev (@martin_fmi)", 420, 230);
		graphics.setColor(Color.BLACK);
	}
	
	private void createAnimationButtons() {
		try {
			playIconURL = MainDisplayPanel.class.getResource("/icons/play.png").toURI().toURL();
			pauseIconURL = MainDisplayPanel.class.getResource("/icons/pause.png").toURI().toURL();
			prevIconURL = MainDisplayPanel.class.getResource("/icons/prev.png").toURI().toURL();
			nextIconURL = MainDisplayPanel.class.getResource("/icons/next.png").toURI().toURL();
			
			animationButtonsPanel = new JPanel();
			animationButtonsPanel.setBackground(Color.WHITE);
			JButton prev = new JButton(new ImageIcon(prevIconURL));
			prev.setBackground(Color.WHITE);
			JButton pause = new JButton(new ImageIcon(pauseIconURL));
			pause.setBackground(Color.WHITE);
			JButton next = new JButton(new ImageIcon(nextIconURL));
			next.setBackground(Color.WHITE);
			
			PlayPauseListener playPauseListener = new PlayPauseListener(pause, playIconURL, pauseIconURL);
			pause.addActionListener(playPauseListener);
			prev.addActionListener(new PrevListener(playPauseListener));
			next.addActionListener(new NextListener(playPauseListener));
			
			animationButtonsPanel.add(prev);
			animationButtonsPanel.add(pause);
			animationButtonsPanel.add(next);
			add(animationButtonsPanel, BorderLayout.SOUTH);
			animationButtonsPanel.setVisible(false);
		} catch (MalformedURLException | URISyntaxException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
		
	}

	public void addPlayButtons() {
		if (!animationButtonsAdded) {
			animationButtonsPanel.setVisible(true);
			animationButtonsAdded = true;
		}
	}

}
