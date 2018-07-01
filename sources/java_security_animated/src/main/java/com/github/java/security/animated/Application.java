package com.github.java.security.animated;

import javax.swing.SwingUtilities;

import com.github.java.security.animated.view.MainFrame;

public class Application {

    public static void main(String[] args) {
		
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	MainFrame frame = new MainFrame();
            	frame.init();
            }
        });
    }
    
}
