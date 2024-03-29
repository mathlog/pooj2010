/*
	A basic extension of the java.awt.Dialog class
 */
package opoo.practica1.fecha;

import java.awt.*;
import java.awt.event.*;

public class QuitDialog extends Dialog {
	public QuitDialog(Frame parent, boolean modal) {
		super(parent, modal);

		// Keep a local reference to the invoking frame
		frame = parent;

		// This code is automatically generated by Visual Cafe when you add
		// components to the visual environment. It instantiates and initializes
		// the components. To modify the code, only use code syntax that matches
		// what Visual Cafe can generate, or Visual Cafe may be unable to back
		// parse your Java file into its visual environment.
		// {{INIT_CONTROLS
		setLayout(null);
		setBackground(new java.awt.Color(252, 245, 254));
		setSize(253, 120);
		setVisible(false);
		yesButton.setLabel("exit");
		add(yesButton);
		yesButton.setBackground(new java.awt.Color(152, 162, 231));
		yesButton.setFont(new Font("Dialog", Font.BOLD, 12));
		yesButton.setBounds(24, 72, 79, 22);
		noButton.setLabel("cancel");
		add(noButton);
		noButton.setBackground(new java.awt.Color(152, 162, 231));
		noButton.setFont(new Font("Dialog", Font.BOLD, 12));
		noButton.setBounds(144, 72, 79, 22);
		label1.setText("Do you really want to exit?");
		label1.setAlignment(java.awt.Label.CENTER);
		add(label1);
		label1.setBounds(36, 24, 180, 23);
		setTitle("AWT Application - Exit");
		// }}

		// {{REGISTER_LISTENERS
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		noButton.addActionListener(lSymAction);
		yesButton.addActionListener(lSymAction);
		// }}
	}

	public void addNotify() {
		// Record the size of the window prior to calling parents addNotify.
		Dimension d = getSize();

		super.addNotify();

		if (fComponentsAdjusted)
			return;

		// Adjust components according to the insets
		setSize(getInsets().left + getInsets().right + d.width, getInsets().top
				+ getInsets().bottom + d.height);
		Component components[] = getComponents();
		for (int i = 0; i < components.length; i++) {
			Point p = components[i].getLocation();
			p.translate(getInsets().left, getInsets().top);
			components[i].setLocation(p);
		}
		fComponentsAdjusted = true;
	}

	public QuitDialog(Frame parent, String title, boolean modal) {
		this(parent, modal);
		setTitle(title);
	}

	/**
	 * Shows or hides the component depending on the boolean flag b.
	 * 
	 * @param b
	 *            if true, show the component; otherwise, hide the component.
	 * @see java.awt.Component#isVisible
	 */
	public void setVisible(boolean b) {
		if (b) {
			Rectangle bounds = getParent().getBounds();
			Rectangle abounds = getBounds();

			setLocation(bounds.x + (bounds.width - abounds.width) / 2, bounds.y
					+ (bounds.height - abounds.height) / 2);
			Toolkit.getDefaultToolkit().beep();
		}
		super.setVisible(b);
	}

	// Used for addNotify check.
	boolean fComponentsAdjusted = false;
	// Invoking frame
	Frame frame = null;

	// {{DECLARE_CONTROLS
	java.awt.Button yesButton = new java.awt.Button();
	java.awt.Button noButton = new java.awt.Button();
	java.awt.Label label1 = new java.awt.Label();

	// }}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == yesButton)
				yesButton_ActionPerformed(event);
			else if (object == noButton)
				noButton_ActionPerformed(event);
		}
	}

	void yesButton_ActionPerformed(java.awt.event.ActionEvent event) {
		// to do: code goes here.

		yesButton_ActionPerformed_Interaction1(event);
	}

	void yesButton_ActionPerformed_Interaction1(java.awt.event.ActionEvent event) {
		try {
			frame.setVisible(false); // Hide the invoking frame
			frame.dispose(); // Free system resources
			this.dispose(); // Free system resources
			System.exit(0); // close the application
		} catch (Exception e) {
		}
	}

	void noButton_ActionPerformed(java.awt.event.ActionEvent event) {
		// to do: code goes here.

		noButton_ActionPerformed_Interaction1(event);
	}

	void noButton_ActionPerformed_Interaction1(java.awt.event.ActionEvent event) {
		try {
			this.dispose();
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosed(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == QuitDialog.this)
				QuitDialog_WindowClosed(event);
		}

		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == QuitDialog.this)
				QuitDialog_WindowClosing(event);
		}
	}

	void QuitDialog_WindowClosing(java.awt.event.WindowEvent event) {
		// to do: code goes here.

		QuitDialog_WindowClosing_Interaction1(event);
	}

	void QuitDialog_WindowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.dispose();
		} catch (Exception e) {
		}
	}

	void QuitDialog_WindowClosed(java.awt.event.WindowEvent event) {
		// to do: code goes here.

	}
}
