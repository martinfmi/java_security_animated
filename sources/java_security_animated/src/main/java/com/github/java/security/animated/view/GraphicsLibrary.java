package com.github.java.security.animated.view;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

/**
 * A library of Java 2d components that are reused across controllers.
 * 
 * @author Martin
 */
public class GraphicsLibrary {

	private static final Logger LOGGER = Logger.getLogger(GraphicsLibrary.class.getName());

	public static final Color COLOR_LIGHT_BLUE = new Color(137, 207, 240);
	
	public static void drawJVMDiagram(Graphics graphics) {

		Graphics2D g2 = (Graphics2D) graphics;

		Rectangle os = new Rectangle(380, 500, 300, 40);
		Rectangle jvm = new Rectangle(405, 430, 250, 70);

		g2.draw(os);
		g2.drawString("OS", 510, 525);
		g2.draw(jvm);
		g2.drawString("JVM", 510, 470);
	}

	public static void drawArrow(Graphics2D g2, int x1, int y1, int x2, int y2) {
		g2.drawLine(x1, y1, x2, y2);
		double angle = Math.atan2(y2 - y1, x2 - x1);
		AffineTransform tx = g2.getTransform();
		tx.translate(x2, y2);
		tx.rotate(angle - Math.PI / 2d);
		
		AffineTransform oldTx = g2.getTransform();
		g2.setTransform(tx);
		Polygon arrowHead = new Polygon();
		arrowHead.addPoint(0, 5);
		arrowHead.addPoint(-5, -5);
		arrowHead.addPoint(5, -5);
		g2.setPaint(Color.BLACK);
		g2.fill(arrowHead);
		g2.setTransform(oldTx);
	}
	
	public static void drawImage(Graphics g2, String path, int x, int y) {
		try {
			BufferedImage img = ImageIO.read(GraphicsLibrary.class.getResource(path));
			g2.drawImage(img, x, y, null);
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public static void drawRect(Graphics2D graphics, int x, int y, int width, int height, String text) {
		drawRect(graphics, x, y, width, height, text, null);
	}

	public static void drawRect(Graphics2D graphics, int x, int y, int width, int height, String text,
			Color backgroundColor) {
		Color currentColor = graphics.getColor();
		if (backgroundColor != null) {
			graphics.setPaint(backgroundColor);
		} else {
			graphics.setPaint(Color.WHITE);
		}
		Rectangle rect = new Rectangle(x, y, width, height);
		graphics.fill(rect);
		graphics.setPaint(currentColor);
		graphics.draw(new Rectangle(x, y, width, height));
		
	    FontMetrics metrics = graphics.getFontMetrics(graphics.getFont());
	    int textX  = x + (width - metrics.stringWidth(text)) / 2;
	    int textY = y + ((height - metrics.getHeight()) / 2) + metrics.getAscent();
	    
		graphics.drawString(text, textX, textY);
	}

}
