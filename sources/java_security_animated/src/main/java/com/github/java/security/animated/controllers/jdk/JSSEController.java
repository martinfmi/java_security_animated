package com.github.java.security.animated.controllers.jdk;

import java.awt.Graphics;

import com.github.java.security.animated.controllers.BaseController;
import com.github.java.security.animated.view.MainDisplayPanel;

public class JSSEController extends BaseController {

	private static final String SNIPPET_PATH_INTRO = "/snippets/jdk/jsse/intro.txt";

	private static final String SNIPPET_PATH_TLS_HANDSHAKE = "/snippets/jdk/jsse/tls_handshake.txt";

	private static final String SNIPPET_PATH_SERVER_EXAMPLE = "/snippets/jdk/jsse/jsse_server.txt";

	private static final String SNIPPET_PATH_CLIENT_EXAMPLE = "/snippets/jdk/jsse/jsse_client.txt";

	public JSSEController(MainDisplayPanel displayPanel) {
		super(displayPanel);
		addStep((graphics, controller) -> startStep(graphics));
		addStep((graphics, controller) -> stepTlsHandshake(graphics));
		addStep((graphics, controller) -> stepServerExample(graphics));
		addStep((graphics, controller) -> stepClientExample(graphics));
		
	}

	private void startStep(Graphics graphics) {
		drawSnippet(graphics, SNIPPET_PATH_INTRO);
	}

	private void stepTlsHandshake(Graphics graphics) {
		clearSnippetArea(graphics);
		drawSnippet(graphics, SNIPPET_PATH_TLS_HANDSHAKE);
	}

	private void stepServerExample(Graphics graphics) {
		clearSnippetArea(graphics);
		clearDrawingArea(graphics);
		drawSnippet(graphics, SNIPPET_PATH_SERVER_EXAMPLE);
	}

	private void stepClientExample(Graphics graphics) {
		clearSnippetArea(graphics);
		clearDrawingArea(graphics);
		drawSnippet(graphics, SNIPPET_PATH_CLIENT_EXAMPLE);
	}
	
}
