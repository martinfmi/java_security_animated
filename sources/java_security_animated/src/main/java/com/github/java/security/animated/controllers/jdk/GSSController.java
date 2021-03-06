package com.github.java.security.animated.controllers.jdk;

import java.awt.Graphics;

import com.github.java.security.animated.controllers.BaseController;
import com.github.java.security.animated.view.MainDisplayPanel;

public class GSSController extends BaseController {

	private static final String SNIPPET_PATH_INTRO = "/snippets/jdk/gssapi/intro.txt";
	
	public GSSController(MainDisplayPanel displayPanel) {
		super(displayPanel);
		addStep((graphics, controller) -> startStep(graphics));
	}
	
	private void startStep(Graphics graphics) {
		drawSnippet(graphics, SNIPPET_PATH_INTRO);
	}
	
}
