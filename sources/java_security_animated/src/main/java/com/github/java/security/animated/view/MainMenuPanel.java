
package com.github.java.security.animated.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.java.security.animated.controllers.modules.NotImplementedController;

public class MainMenuPanel extends JPanel {

	private static final long serialVersionUID = -5628979699524965305L;
	
	private JPanel displayPanel;

	public MainMenuPanel(JPanel displayPanel) {
		this.displayPanel = displayPanel;
	}
	
	public void init() {
		setSize(250, 600);
		setBorder(BorderFactory.createEmptyBorder(60, 20,0, 0));
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JLabel frameworkLabel = new JLabel("Frameworks");
		frameworkLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		add(frameworkLabel);
		
		addMenuItem("Spring", new NotImplementedController(displayPanel));
		addMenuItem("Java EE", new NotImplementedController(displayPanel));
		addMenuItem("OSGi", new NotImplementedController(displayPanel));
		
		JLabel jreLabel = new JLabel("Java Runtime Environment");
		jreLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 5, 0));
		add(jreLabel);
		
		addMenuItem("Sandbox model", new NotImplementedController(displayPanel));
		addMenuItem("JAAS", new NotImplementedController(displayPanel));
		addMenuItem("JSSE", new NotImplementedController(displayPanel));
		addMenuItem("GSSAPI", new NotImplementedController(displayPanel));
		addMenuItem("JCA", new NotImplementedController(displayPanel));
		addMenuItem("SASL", new NotImplementedController(displayPanel));
		addMenuItem("PKI Utilities", new NotImplementedController(displayPanel));
		addMenuItem("JAR Verification", new NotImplementedController(displayPanel));
		addMenuItem("XML Signatures", new NotImplementedController(displayPanel));

		JLabel jvmLabel = new JLabel("Java Virtual Machine");
		jvmLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 5, 0));
		add(jvmLabel);
		
		addMenuItem("Bytecode Verification", new NotImplementedController(displayPanel));
	}
	
	public void addMenuItem(String itemName, ActionListener actionListener) {
		JButton menuItem = new JButton(itemName);
		menuItem.setMaximumSize(new Dimension(Integer.MAX_VALUE, menuItem.getMinimumSize().height));
		menuItem.addActionListener(actionListener);
		add(menuItem);
	}
}
