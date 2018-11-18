package com.github.java.security.animated.controllers.jdk;

import java.awt.Graphics;

import com.github.java.security.animated.controllers.BaseController;
import com.github.java.security.animated.view.MainDisplayPanel;

public class JARVerificationController extends BaseController {

	private static final String SNIPPET_PATH_JAR_SIGNING = "/snippets/jdk/jar_verification/jar_signing.txt";
	
	private static final String SNIPPET_PATH_JAR_VERIFICATION = "/snippets/jdk/jar_verification/jar_verification.txt";
	
	public JARVerificationController(MainDisplayPanel displayPanel) {
		super(displayPanel);
		addStep((graphics, controller) -> startStep(graphics));
		addStep((graphics, controller) -> stepJarVerification(graphics));
	}
	
	private void startStep(Graphics graphics) {
		drawSnippet(graphics, SNIPPET_PATH_JAR_SIGNING);
		highlightSnippetLines(graphics, 5, 5);
	}

	private void stepJarVerification(Graphics graphics) {
		clearSnippetArea(graphics);
		drawSnippet(graphics, SNIPPET_PATH_JAR_VERIFICATION);
		highlightSnippetLines(graphics, 5, 5);
	}

}
