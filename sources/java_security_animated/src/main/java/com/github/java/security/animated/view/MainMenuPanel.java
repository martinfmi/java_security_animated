
package com.github.java.security.animated.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.java.security.animated.controllers.AnimationController;
import com.github.java.security.animated.controllers.BaseController;
import com.github.java.security.animated.controllers.NotImplementedController;
import com.github.java.security.animated.controllers.frameworks.JavaEEController;
import com.github.java.security.animated.controllers.frameworks.OSGiController;
import com.github.java.security.animated.controllers.frameworks.SpringController;
import com.github.java.security.animated.controllers.jdk.GSSController;
import com.github.java.security.animated.controllers.jdk.JAASController;
import com.github.java.security.animated.controllers.jdk.JARVerificationController;
import com.github.java.security.animated.controllers.jdk.JCAController;
import com.github.java.security.animated.controllers.jdk.JSSEController;
import com.github.java.security.animated.controllers.jdk.PKIController;
import com.github.java.security.animated.controllers.jdk.SASLController;
import com.github.java.security.animated.controllers.jdk.XMLSignaturesController;
import com.github.java.security.animated.controllers.jvm.AutomaticMemoryManagementController;
import com.github.java.security.animated.controllers.jvm.BytecodeVeficationController;
import com.github.java.security.animated.controllers.jvm.SandboxController;
import com.github.java.security.animated.controllers.jvm.SecureClassoadingController;
import com.github.java.security.animated.controllers.jvm.StrongDataTypingController;

public class MainMenuPanel extends JPanel {

	private static final long serialVersionUID = -5628979699524965305L;
	
	private MainDisplayPanel displayPanel;

	public MainMenuPanel(MainDisplayPanel displayPanel) {
		this.displayPanel = displayPanel;
	}
	
	public void init() {
		setSize(250, 600);
		setBorder(BorderFactory.createEmptyBorder(30, 20,0, 0));
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JLabel frameworkLabel = new JLabel("Frameworks");
		frameworkLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		add(frameworkLabel);
		
		addMenuItem("Spring", new SpringController(displayPanel));
		addMenuItem("Java EE", new JavaEEController(displayPanel));
		addMenuItem("OSGi", new OSGiController(displayPanel));
		
		JLabel jreLabel = new JLabel("Java Development Kit");
		jreLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 5, 0));
		add(jreLabel);
		
		addMenuItem("JAAS", new JAASController(displayPanel));
		addMenuItem("JSSE", new JSSEController(displayPanel));
		addMenuItem("GSSAPI", new GSSController(displayPanel));
		addMenuItem("JCA", new JCAController(displayPanel));
		addMenuItem("SASL", new SASLController(displayPanel));
		addMenuItem("PKI Utilities", new PKIController(displayPanel));
		addMenuItem("JAR Verification", new JARVerificationController(displayPanel));
		addMenuItem("XML Signatures", new XMLSignaturesController(displayPanel));
		
		JLabel jvmLabel = new JLabel("JVM Runtime Environment");
		jvmLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 5, 0));
		add(jvmLabel);
		addMenuItem("Sandbox model", new SandboxController(displayPanel));
		addMenuItem("Strong data typing", new StrongDataTypingController(displayPanel));
		addMenuItem("Automatic memory management", new AutomaticMemoryManagementController(displayPanel));
		addMenuItem("Secure class loading", new SecureClassoadingController(displayPanel));
		addMenuItem("Bytecode Verification", new BytecodeVeficationController(displayPanel));
	}
	
	public void addMenuItem(String itemName, BaseController actionListener) {
		JButton menuItem = new JButton(itemName);
		menuItem.setMaximumSize(new Dimension(Integer.MAX_VALUE, menuItem.getMinimumSize().height));
		menuItem.addActionListener(new AnimationController(actionListener));
		add(menuItem);
	}
}
