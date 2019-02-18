package com.github.java.security.animated.controllers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.util.LinkedList;
import java.util.function.BiConsumer;

import com.github.java.security.animated.util.SnippetUtil;
import com.github.java.security.animated.view.MainDisplayPanel;


public abstract class BaseController implements ActionListener {
	private static final int MARGIN_SIZE = 20;

	private static final Color HIGHLIGHT_COLOR = Color.BLUE;

	private static Font SNIPPET_FONT = new Font("Monaco", Font.PLAIN, 14);

	public static String currentSnippetPath;
	
	protected MainDisplayPanel displayPanel;
	
	private TextLayout[] snippetLines;

	private LinkedList<BiConsumer<Graphics, BaseController>> steps = new LinkedList<>();
	
	private int currentStepIndex = -1;
	
	public BaseController(MainDisplayPanel displayPanel) {
		this.displayPanel = displayPanel;
	}

	public void addStep(BiConsumer<Graphics, BaseController> step) {
		steps.add(step);
	}

	public void clearSnippetArea(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.clearRect(250, 0, 550, 305);
		graphics.fillRect(250, 0, 550, 305);
		graphics.setColor(Color.BLACK);
	}

	public void clearDrawingArea(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.clearRect(250, 260, 550, 295);
		graphics.fillRect(250, 260, 550, 295);
		graphics.setColor(Color.BLACK);
	}

	public void drawSnippet(Graphics graphics, String path) {
		String[] text = SnippetUtil.loadSnippet(path);
		snippetLines = new TextLayout[text.length];
		Graphics2D graphics2D = (Graphics2D) graphics;
		FontRenderContext FontRC = graphics2D.getFontRenderContext();
		graphics.drawRect(300, 50, 450, 30 + MARGIN_SIZE * (text.length - 1));
		
		int margin = 0;
		int index = 0;
		for (String line : text) {
			TextLayout layout = new TextLayout(line, SNIPPET_FONT, FontRC);
			layout.draw(graphics2D, 310, 70 + margin);
			snippetLines[index++] = layout;
			margin += MARGIN_SIZE;
		}

	}

	public void highlightSnippetLines(Graphics graphics, int from, int to) {
		if (from > snippetLines.length || to < 1 || from > to) {
			return;
		}
		
		int start = from < 1 ? 1 : from;
		int end = to > snippetLines.length ? snippetLines.length : to;

		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics.setColor(HIGHLIGHT_COLOR);
		for (int index = start; index <= end; index++) {
			snippetLines[index-1].draw(graphics2D, 310, 70 + (index-1) * MARGIN_SIZE);
		}
		graphics.setColor(Color.BLACK);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (currentStepIndex + 1 < steps.size()) {
			currentStepIndex++;
			BiConsumer<Graphics, BaseController> next = steps.get(currentStepIndex);
			displayPanel.showExecutableButton(false);
			next.accept(displayPanel.getGraphics(), this);
		}
	}

	public void clear() {
		clearDrawingArea(displayPanel.getGraphics());
		clearSnippetArea(displayPanel.getGraphics());
	}
	
	public void reset() {
		currentStepIndex = -1;
	}
	
	public void setCurrentStepIndex(int currentStepIndex) {
		this.currentStepIndex = currentStepIndex;
		this.currentStepIndex = this.currentStepIndex < -1 ? -1 : this.currentStepIndex;
		this.currentStepIndex = this.currentStepIndex > steps.size() ? steps.size() : this.currentStepIndex;
	}
	
	public int getCurrentStepIndex() {
		return currentStepIndex;
	}
	
	public MainDisplayPanel getDisplayPanel() {
		return displayPanel;
	}
	
	public LinkedList<BiConsumer<Graphics, BaseController>> getSteps() {
		return steps;
	}
}
