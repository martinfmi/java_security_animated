package com.github.java.security.animated;

import java.awt.Graphics;
import java.util.function.BiConsumer;

import javax.swing.Timer;

import com.github.java.security.animated.controllers.BaseController;

public final class AnimationManager {

	protected int delay = 7000;
	
	private Timer animationTimer;

	private BaseController lastAnimated;
	
	private static AnimationManager instance = new AnimationManager();
	
	public static AnimationManager getInstance() {
		return instance;
	}
	
	public void animate(BaseController currentAnimationController) {
		this.lastAnimated = currentAnimationController;
		if(animationTimer != null) {
			animationTimer.stop();
		}
		currentAnimationController.reset();
		currentAnimationController.clear();
		animationTimer = new Timer(delay, currentAnimationController);
		animationTimer.setInitialDelay(0);
		animationTimer.start();
	}
	
	public void pause() {
		if(animationTimer != null) {
			animationTimer.stop();
		}
	}
	
	public void resume() {
		animationTimer.start();
	}
	
	public void next() {
		if(animationTimer != null && lastAnimated != null) {
			animationTimer.stop();
			animationTimer.start();
		}
	}
	
	public void prev() {
		if(lastAnimated != null && lastAnimated != null) {
			animationTimer.stop();
			int prevStepIndex = lastAnimated.getCurrentStepIndex() - 2;
			lastAnimated.setCurrentStepIndex(prevStepIndex);
			
			// clear state and replay latest steps ... 
			lastAnimated.clear();
			int start = -1;
			for(BiConsumer<Graphics, BaseController> step : lastAnimated.getSteps()) {
				if(start >= prevStepIndex) {
					break;
				}
				step.accept(lastAnimated.getDisplayPanel().getGraphics(), lastAnimated);
				start++;
			}
			animationTimer.start();
		}
	}
	
	public void setDelay(int delay) {
		this.delay = delay;
	}
	
	public int getDelay() {
		return delay;
	}
}
