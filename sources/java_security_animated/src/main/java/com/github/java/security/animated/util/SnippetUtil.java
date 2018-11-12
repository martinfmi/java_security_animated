package com.github.java.security.animated.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class SnippetUtil {

	private static final Logger LOGGER = Logger.getLogger(SnippetUtil.class.getName());

	/**
	 * Loads the contents of a snippet from the application resources.
	 * 
	 * @param path
	 *            The path in the application resources that containts the snippet.
	 * @return The snippet line by line
	 */
	public static String[] loadSnippet(String path) {

		InputStream contentStream = null;
		BufferedReader br = null;

		try {
			contentStream = SnippetUtil.class.getResourceAsStream(path);
			LinkedList<String> lines = new LinkedList<String>();
			br = new BufferedReader(new InputStreamReader(contentStream));
			String read;

			while ((read = br.readLine()) != null) {
				lines.add(read);
			}
			return lines.toArray(new String[0]);
		} catch (Exception ex) {
			LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
			return new LinkedList<>().toArray(new String[0]);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					LOGGER.log(Level.WARNING, e.getMessage(), e);
				}
			}
		}

	}

}
