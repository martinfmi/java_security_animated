package com.github.java.security.animated.controllers.jdk;

import java.awt.Graphics;

import com.github.java.security.animated.controllers.BaseController;
import com.github.java.security.animated.view.MainDisplayPanel;

public class XMLSignaturesController extends BaseController {
	
	private static final String SNIPPET_PATH_INTRO = "/snippets/jdk/xml_signatures/intro.txt";
	
	private static final String SNIPPET_PATH_XML_SIGNATURES_IN_JDK = "/snippets/jdk/xml_signatures/xml_signatures_in_jdk.txt";
	
	public XMLSignaturesController(MainDisplayPanel displayPanel) {
		super(displayPanel);
		addStep((graphics, controller) -> startStep(graphics));
		addStep((graphics, controller) -> startXmlSignaturesInJDK(graphics));
	}
	
	private void startStep(Graphics graphics) {
		drawSnippet(graphics, SNIPPET_PATH_INTRO);
	}
	
	private void startXmlSignaturesInJDK(Graphics graphics) {
		clearSnippetArea(graphics);
		clearDrawingArea(graphics);
		drawSnippet(graphics, SNIPPET_PATH_XML_SIGNATURES_IN_JDK);
	}
}
