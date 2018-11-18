package com.github.java.security.animated.controllers.jvm;

import java.awt.Graphics;

import com.github.java.security.animated.controllers.BaseController;
import com.github.java.security.animated.view.MainDisplayPanel;

public class StrongDataTypingController extends BaseController {

	private static final String SNIPPET_PATH_INTRO = "/snippets/jvm/strong_data_typing/intro.txt";

	private static final String SNIPPET_PATH_POSSIBLE_ISSUES = "/snippets/jvm/strong_data_typing/possible_issues.txt";
	
	public StrongDataTypingController(MainDisplayPanel displayPanel) {
		super(displayPanel);
		addStep((graphics, controller) -> startStep(graphics));
		addStep((graphics, controller) -> possibleIssuesStep(graphics));	}

	private void startStep(Graphics graphics) {
		drawSnippet(graphics, SNIPPET_PATH_INTRO);
	}
	
	private void possibleIssuesStep(Graphics graphics) {
		clearSnippetArea(graphics);
		drawSnippet(graphics, SNIPPET_PATH_POSSIBLE_ISSUES);
	}
	
}
