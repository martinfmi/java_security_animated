package com.github.java.security.animated.controllers.jdk;

import java.awt.Graphics;

import com.github.java.security.animated.controllers.BaseController;
import com.github.java.security.animated.view.MainDisplayPanel;

public class JAASController extends BaseController {

	private static final String SNIPPET_PATH_INTRO = "/snippets/jdk/jaas/intro.txt";
	
	private static final String SNIPPET_PATH_CORE_CLASSES = "/snippets/jdk/jaas/core_classes.txt";
	
	public JAASController(MainDisplayPanel displayPanel) {
		super(displayPanel);
		addStep((graphics, controller) -> startStep(graphics));
		addStep((graphics, controller) -> stepCoreClasses(graphics));
	}
	
	private void startStep(Graphics graphics) {
		drawSnippet(graphics, SNIPPET_PATH_INTRO);
	}

	private void stepCoreClasses(Graphics graphics) {
		clearSnippetArea(graphics);
		drawSnippet(graphics, SNIPPET_PATH_CORE_CLASSES);
	}

}
