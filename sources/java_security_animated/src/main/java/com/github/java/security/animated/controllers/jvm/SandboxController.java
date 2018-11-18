package com.github.java.security.animated.controllers.jvm;

import java.awt.Graphics;
import java.awt.Graphics2D;

import com.github.java.security.animated.controllers.BaseController;
import com.github.java.security.animated.view.GraphicsLibrary;
import com.github.java.security.animated.view.MainDisplayPanel;

public class SandboxController extends BaseController {

	private static final String SNIPPET_PATH_INTRO = "/snippets/jvm/sandbox_model/intro.txt";

	private static final String SNIPPET_FUNDAMENTAL_CONCEPTS = "/snippets/jvm/sandbox_model/fundamental_concepts.txt";

	private static final String SNIPPET_PROTECTION_DOMAIN = "/snippets/jvm/sandbox_model/protection_domain.txt";

	private static final String SNIPPET_POLICY_FILE = "/snippets/jvm/sandbox_model/policy_file.txt";

	private static final String SNIPPET_POLICY_FILE_IMPLIES = "/snippets/jvm/sandbox_model/policy_file_implies.txt";

	private static final String SNIPPET_PERMISSION_CHECKING_WITH_SECURITY_MANAGER = "/snippets/jvm/sandbox_model/permission_checking_security_manager.txt";

	private static final String SNIPPET_PERMISSION_CHECKING_WITH_SECURITY_MANAGER_EXAMPLE = "/snippets/jvm/sandbox_model/permission_checking_security_manager_example.txt";

	private static final String SNIPPET_PERMISSION_CHECKING_WITH_ACCESS_CONTROLLER = "/snippets/jvm/sandbox_model/permission_checking_access_controller.txt";

	private static final String SNIPPET_PRIVELEGE_ESCALATION = "/snippets/jvm/sandbox_model/privelege_escalation.txt";
	
	private static final String SNIPPET_JAAS_EXTENSION = "/snippets/jvm/sandbox_model/jaas_extension.txt";

	private static final String SNIPPET_FURTHER_ENHANCEMENTS = "/snippets/jvm/sandbox_model/further_enhancements.txt";
	
	private static final String SNIPPET_JIGSAW_ENHANCEMENTS = "/snippets/jvm/sandbox_model/jigsaw_enhancements.txt";

	public SandboxController(MainDisplayPanel displayPanel) {
		super(displayPanel);
		addStep((graphics, controller) -> startStep(graphics));
		addStep((graphics, controller) -> stepFundamentalConcepts(graphics));
		addStep((graphics, controller) -> stepPolicyFile(graphics)); 
		addStep((graphics, controller) -> stepPolicyFileImplies(graphics));
		addStep((graphics, controller) -> stepProtectionDomainInterception(graphics));
		addStep((graphics, controller) -> stepPermissionCheckingWithSecurityManager(graphics)); // JVM and custom done (by app servers)
		addStep((graphics, controller) -> stepPermissionCheckingWithSecurityManagerExample(graphics)); // JVM and custom done (by app servers)
		addStep((graphics, controller) -> stepPermissionCheckingWithAccessController(graphics)); 
		addStep((graphics, controller) -> stepPrivelegeEscalation(graphics)); 
		addStep((graphics, controller) -> stepJAASExtension(graphics)); // place reference to the JAAS section
		addStep((graphics, controller) -> stepFurtherEnhancements(graphics)); 
		addStep((graphics, controller) -> stepJigsawEnhancements(graphics)); 
	}
	
	private void startStep(Graphics graphics) {
		drawSnippet(graphics, SNIPPET_PATH_INTRO);
		GraphicsLibrary.drawJVMDiagram(graphics);
	}
	
	private void stepFundamentalConcepts(Graphics graphics) {
		Graphics2D g2 = (Graphics2D) graphics;
		clearSnippetArea(graphics);
		drawSnippet(graphics, SNIPPET_FUNDAMENTAL_CONCEPTS);
		GraphicsLibrary.drawRect(g2, 485, 480, 170, 10, "java.lang.SecurityManager", GraphicsLibrary.COLOR_LIGHT_BLUE);
		GraphicsLibrary.drawRect(g2, 485, 490, 170, 10, "java.security.AccessController", GraphicsLibrary.COLOR_LIGHT_BLUE);
	}

	private void stepPolicyFile(Graphics graphics) {
		Graphics2D g2 = (Graphics2D) graphics;
		clearSnippetArea(graphics);
		clearDrawingArea(graphics);
		drawSnippet(graphics, SNIPPET_POLICY_FILE);
		highlightSnippetLines(g2, 6, 8);
		GraphicsLibrary.drawJVMDiagram(graphics);
		GraphicsLibrary.drawRect(g2, 485, 480, 170, 10, "java.lang.SecurityManager");
		GraphicsLibrary.drawRect(g2, 485, 490, 170, 10, "java.security.AccessController");
		GraphicsLibrary.drawArrow(g2, 665, 465, 685, 465);
		GraphicsLibrary.drawRect(g2, 695, 455, 80, 20, "security.policy", GraphicsLibrary.COLOR_LIGHT_BLUE);
		GraphicsLibrary.drawArrow(g2, 490, 390, 490, 410);
		GraphicsLibrary.drawRect(g2, 460, 350, 70, 30, "application");
		GraphicsLibrary.drawArrow(g2, 540, 365, 550, 365);
		GraphicsLibrary.drawRect(g2, 560, 350, 70, 30, "lib.jar", GraphicsLibrary.COLOR_LIGHT_BLUE);
	}
	
	private void stepPolicyFileImplies(Graphics graphics) {
		clearSnippetArea(graphics);
		drawSnippet(graphics, SNIPPET_POLICY_FILE_IMPLIES);
	}

	private void stepProtectionDomainInterception(Graphics graphics) {
		Graphics2D g2 = (Graphics2D) graphics;
		clearSnippetArea(graphics);
		clearDrawingArea(graphics);
		GraphicsLibrary.drawJVMDiagram(graphics);
		drawSnippet(g2, SNIPPET_PROTECTION_DOMAIN);
		highlightSnippetLines(g2, 9, 9);
		GraphicsLibrary.drawRect(g2, 440, 320, 90, 30, "jar.lib");
		GraphicsLibrary.drawArrow(g2, 540, 335, 540, 335);
		GraphicsLibrary.drawRect(g2, 550, 320, 90, 30, "bytecode verifier");
		GraphicsLibrary.drawArrow(g2, 590, 360, 590, 370);
		GraphicsLibrary.drawRect(g2, 550, 380, 90, 30, "classloader");
		GraphicsLibrary.drawArrow(g2, 590, 415, 590, 420);

		GraphicsLibrary.drawArrow(g2, 650, 395, 660, 395);
		GraphicsLibrary.drawRect(g2, 670, 380, 110, 30, "protection domain", GraphicsLibrary.COLOR_LIGHT_BLUE);
	}

	private void stepPermissionCheckingWithSecurityManager(Graphics graphics) {
		Graphics2D g2 = (Graphics2D) graphics;
		clearSnippetArea(graphics);
		clearDrawingArea(graphics);
		drawSnippet(graphics, SNIPPET_PERMISSION_CHECKING_WITH_SECURITY_MANAGER);
		GraphicsLibrary.drawJVMDiagram(graphics);
		GraphicsLibrary.drawRect(g2, 485, 460, 170, 20, "java.lang.SecurityManager", GraphicsLibrary.COLOR_LIGHT_BLUE);
		GraphicsLibrary.drawRect(g2, 485, 480, 170, 20, "java.security.AccessController");
	}
	
	private void stepPermissionCheckingWithSecurityManagerExample(Graphics graphics) {
		clearSnippetArea(graphics);
		drawSnippet(graphics, SNIPPET_PERMISSION_CHECKING_WITH_SECURITY_MANAGER_EXAMPLE);
		highlightSnippetLines(graphics, 4, 7);
	}
	
	private void stepPermissionCheckingWithAccessController(Graphics graphics) {
		Graphics2D g2 = (Graphics2D) graphics;
		clearSnippetArea(graphics);
		clearDrawingArea(graphics);
		GraphicsLibrary.drawJVMDiagram(graphics);
		GraphicsLibrary.drawRect(g2, 485, 460, 170, 20, "java.lang.SecurityManager");
		GraphicsLibrary.drawRect(g2, 485, 480, 170, 20, "java.security.AccessController", GraphicsLibrary.COLOR_LIGHT_BLUE);
		drawSnippet(graphics, SNIPPET_PERMISSION_CHECKING_WITH_ACCESS_CONTROLLER);
		highlightSnippetLines(graphics, 4, 6);
	}
	
	private void stepPrivelegeEscalation(Graphics graphics) {
		Graphics2D g2 = (Graphics2D) graphics;
		clearSnippetArea(graphics);
		clearDrawingArea(graphics);
		GraphicsLibrary.drawJVMDiagram(graphics);
		GraphicsLibrary.drawRect(g2, 485, 460, 170, 20, "java.lang.SecurityManager");
		GraphicsLibrary.drawRect(g2, 485, 480, 170, 20, "java.security.AccessController");
		drawSnippet(graphics, SNIPPET_PRIVELEGE_ESCALATION);
		highlightSnippetLines(graphics, 5,7);
	}
	
	private void stepJAASExtension(Graphics graphics) {
		Graphics2D g2 = (Graphics2D) graphics;
		clearSnippetArea(graphics);
		clearDrawingArea(graphics);
		drawSnippet(graphics, SNIPPET_JAAS_EXTENSION);
		highlightSnippetLines(g2, 5, 8);
		GraphicsLibrary.drawJVMDiagram(graphics);
		GraphicsLibrary.drawRect(g2, 485, 480, 170, 20, "JAAS", GraphicsLibrary.COLOR_LIGHT_BLUE);
		GraphicsLibrary.drawArrow(g2, 665, 465, 685, 465);
		GraphicsLibrary.drawRect(g2, 695, 455, 80, 20, "security.policy", GraphicsLibrary.COLOR_LIGHT_BLUE);
	}
	
	private void stepFurtherEnhancements(Graphics graphics) {
		clearSnippetArea(graphics);
		clearDrawingArea(graphics);
		drawSnippet(graphics, SNIPPET_FURTHER_ENHANCEMENTS);
		GraphicsLibrary.drawJVMDiagram(graphics);
	}
	
	private void stepJigsawEnhancements(Graphics graphics) {
		Graphics2D g2 = (Graphics2D) graphics;
		clearSnippetArea(graphics);
		drawSnippet(graphics, SNIPPET_JIGSAW_ENHANCEMENTS);
		GraphicsLibrary.drawRect(g2, 485, 480, 170, 20, "java.security.animated", GraphicsLibrary.COLOR_LIGHT_BLUE);
		GraphicsLibrary.drawArrow(g2, 665, 465, 685, 465);
		GraphicsLibrary.drawRect(g2, 695, 455, 80, 20, "security.policy", GraphicsLibrary.COLOR_LIGHT_BLUE);
	}
}
