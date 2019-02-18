package com.github.java.security.animated.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JTextField;

import com.github.java.security.animated.controllers.BaseController;
import com.github.java.security.animated.util.Helper;
import com.github.java.security.animated.util.SnippetUtil;

import jdk.jshell.JShell;

public class ExecuteListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(BaseController.currentSnippetPath != null) {
			// executing current snippet
			String[] snippetLines = SnippetUtil.loadSnippet(BaseController.currentSnippetPath);
			String snippet = String.join(System.lineSeparator(), snippetLines);
			
			JShell jshell = JShell.create();
			
			jshell.addToClasspath(Helper.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			final List<String> imports = Arrays.asList(
					"javax.net.ssl.SSLServerSocketFactory",
					"javax.net.ssl.SSLSocketFactory",
					"java.net.ServerSocket",
					"java.net.Socket",
					"java.io.BufferedReader",
					"java.io.InputStreamReader",
					"java.io.PrintStream",
					"java.io.PrintWriter",
					"javax.swing.JDialog",
					"javax.swing.JFrame",
					"javax.swing.JTextArea",
					"com.github.java.security.animated.util.Helper"
			);
			
			imports.forEach(imp -> jshell.eval("import " + imp + ";"));
//			jshell.onSnippetEvent(se -> jshell.diagnostics(se.snippet()).forEach(a -> System.out.println(a)));
//			jshell.onSnippetEvent(se -> System.out.println(se.status()));
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					jshell.eval(snippet);
				}
			}).start();
			
		}
	}
	
}
