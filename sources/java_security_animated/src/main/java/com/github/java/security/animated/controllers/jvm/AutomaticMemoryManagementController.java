package com.github.java.security.animated.controllers.jvm;

import java.awt.Graphics;
import java.awt.Graphics2D;

import com.github.java.security.animated.controllers.BaseController;
import com.github.java.security.animated.view.GraphicsLibrary;
import com.github.java.security.animated.view.MainDisplayPanel;

public class AutomaticMemoryManagementController extends BaseController {

	private static final String SNIPPET_PATH_INTRO = "/snippets/jvm/memory_management/intro.txt";
	
	private static final String SNIPPET_PATH_POSSIBLE_ISSUES = "/snippets/jvm/memory_management/possible_issues.txt";
	
	public AutomaticMemoryManagementController(MainDisplayPanel displayPanel) {
		super(displayPanel);
		
		addStep((graphics, controller) -> startStep(graphics));
		addStep((graphics, controller) -> possibleIssuesStep(graphics));
	}

	private void startStep(Graphics graphics) {
		drawSnippet(graphics, SNIPPET_PATH_INTRO);
		Graphics2D g2 = (Graphics2D) graphics;
		GraphicsLibrary.drawJVMDiagram(graphics);
		GraphicsLibrary.drawRect(g2, 555, 440, 100, 10, "thread stack", GraphicsLibrary.COLOR_LIGHT_BLUE);
		GraphicsLibrary.drawRect(g2, 555, 450, 100, 10, "thread stack", GraphicsLibrary.COLOR_LIGHT_BLUE);
		GraphicsLibrary.drawRect(g2, 555, 460, 100, 10, "thread stack", GraphicsLibrary.COLOR_LIGHT_BLUE);
		GraphicsLibrary.drawRect(g2, 555, 470, 100, 10, "heap", GraphicsLibrary.COLOR_LIGHT_BLUE);
		GraphicsLibrary.drawRect(g2, 555, 480, 100, 10, "method area", GraphicsLibrary.COLOR_LIGHT_BLUE);
		GraphicsLibrary.drawRect(g2, 555, 490, 100, 10, "constant pool", GraphicsLibrary.COLOR_LIGHT_BLUE);
	}
	
	private void possibleIssuesStep(Graphics graphics) {
		Graphics2D g2 = (Graphics2D) graphics;
		clearSnippetArea(graphics);
		clearDrawingArea(graphics);
		drawSnippet(graphics, SNIPPET_PATH_POSSIBLE_ISSUES);
		GraphicsLibrary.drawJVMDiagram(graphics);
		GraphicsLibrary.drawRect(g2, 555, 440, 100, 10, "thread stack");
		GraphicsLibrary.drawRect(g2, 555, 450, 100, 10, "thread stack");
		GraphicsLibrary.drawRect(g2, 555, 460, 100, 10, "thread stack");
		GraphicsLibrary.drawRect(g2, 555, 470, 100, 10, "heap");
		GraphicsLibrary.drawRect(g2, 555, 480, 100, 10, "method area");
		GraphicsLibrary.drawRect(g2, 555, 490, 100, 10, "constant pool");
		GraphicsLibrary.drawRect(g2, 555, 500, 100, 10, "off-heap memory", GraphicsLibrary.COLOR_LIGHT_BLUE);
		GraphicsLibrary.drawArrow(g2, 665, 465, 685, 465);
		graphics.drawString("JNI", 665, 455);
		GraphicsLibrary.drawRect(g2, 695, 455, 80, 20, "C++ function", GraphicsLibrary.COLOR_LIGHT_BLUE);
	}
	
}
