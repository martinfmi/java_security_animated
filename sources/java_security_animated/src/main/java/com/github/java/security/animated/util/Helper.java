package com.github.java.security.animated.util;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Helper {

	public static JFrame mainFrame;
	
	public static JDialog createDialog(String title, String text) {
		
		JTextArea textField= new JTextArea(text);
		JDialog dialog = new JDialog(mainFrame, title);
		dialog.pack();
		dialog.setVisible(true);
		dialog.toFront();
		dialog.setSize(500,150);
		dialog.setLocation(500,500);
		dialog.add(textField);
		
		return dialog;
	}
	
	public static void appendText(JDialog dialog, String text) {
		JTextArea textField = (JTextArea) dialog.getContentPane().getComponent(0);
		String currentText = textField.getText();
		textField.setText(currentText + System.lineSeparator() + text);
	}
	
}
