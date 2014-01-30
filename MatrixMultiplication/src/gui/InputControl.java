package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InputControl extends JPanel{
	private MatrixControl a = new MatrixControl();
	private MatrixControl b = new MatrixControl();
	
	public InputControl(){
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		add(Box.createHorizontalGlue());
		add(a);
		add(Box.createHorizontalGlue());
		add(b);
		add(Box.createHorizontalGlue());
	}
	
	public MatrixControl getA(){
		return a;
	}
	
	public MatrixControl getB(){
		return b;
	}
}
