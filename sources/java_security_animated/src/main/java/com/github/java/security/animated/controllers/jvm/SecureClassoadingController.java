package com.github.java.security.animated.controllers.jvm;

import java.awt.Graphics;
import java.awt.Graphics2D;

import com.github.java.security.animated.controllers.BaseController;
import com.github.java.security.animated.view.GraphicsLibrary;
import com.github.java.security.animated.view.MainDisplayPanel;

public class SecureClassoadingController extends BaseController {

	private static final String SNIPPET_PATH_INTRO = "/snippets/jvm/secure_classloading/intro.txt";

	private static final String SNIPPET_PATH_SECURE_CLASSLOADING = "/snippets/jvm/secure_classloading/secure_classloading.txt";

	private static final String SNIPPET_PATH_SECURE_CLASSLOADING_PRINCIPALS = "/snippets/jvm/secure_classloading/secure_classloading_principals.txt";
	
	public SecureClassoadingController(MainDisplayPanel displayPanel) {
		super(displayPanel);
		addStep((graphics, controller) -> startStep(graphics));
		addStep((graphics, controller) -> stepSecureClassLoading(graphics));
		addStep((graphics, controller) -> stepSecureClassLoadingPrincipals(graphics));
	}

	private void startStep(Graphics graphics) {
		drawSnippet(graphics, SNIPPET_PATH_INTRO);
		GraphicsLibrary.drawImage(graphics, GraphicsLibrary.IMAGE_PATH_ECLIPSE, 340, 310);
		GraphicsLibrary.drawImage(graphics, GraphicsLibrary.IMAGE_PATH_IDEA, 380, 320);
		GraphicsLibrary.drawImage(graphics, GraphicsLibrary.IMAGE_PATH_NETBEANS, 340, 340);
	}

	private void stepSecureClassLoading(Graphics graphics) {
		clearSnippetArea(graphics);
		Graphics2D g2 = (Graphics2D) graphics;
		drawSnippet(graphics, SNIPPET_PATH_SECURE_CLASSLOADING);
		
		GraphicsLibrary.drawJVMDiagram(graphics);
		GraphicsLibrary.drawArrow(g2, 430, 335, 450, 335);
		GraphicsLibrary.drawRect(g2, 460, 320, 90, 30, "class/JAR file");
		GraphicsLibrary.drawArrow(g2, 560, 335, 560, 335);
		GraphicsLibrary.drawRect(g2, 570, 320, 90, 30, "bytecode verifier");
		GraphicsLibrary.drawArrow(g2, 610, 360, 610, 370);
		GraphicsLibrary.drawRect(g2, 570, 380, 90, 30, "classloader", GraphicsLibrary.COLOR_LIGHT_BLUE);
		GraphicsLibrary.drawArrow(g2, 610, 415, 610, 420);
	}
	
	private void stepSecureClassLoadingPrincipals(Graphics graphics) {
		clearSnippetArea(graphics);
		drawSnippet(graphics, SNIPPET_PATH_SECURE_CLASSLOADING_PRINCIPALS);
		GraphicsLibrary.drawRect((Graphics2D) graphics, 605, 470, 50, 30, "JAAS", GraphicsLibrary.COLOR_LIGHT_BLUE);
	}

}
