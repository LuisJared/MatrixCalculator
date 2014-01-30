package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MatrixControl extends JPanel{
	private JTextField numerator;
	private JTextField denominator;
	private JTextArea body;
	
	public MatrixControl(){
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel temp = new JPanel();
		temp.setLayout(new BoxLayout(temp, BoxLayout.Y_AXIS));
		
		numerator = new JTextField(3);
		temp.add(numerator);
		temp.add(new JSeparator());
		
		denominator = new JTextField(3);
		temp.add(denominator);
		
		add(temp);
		
		body = new JTextArea(6, 30);
		add(body);
	}
	
	public String getBody(){
		return body.getText();
	}
	
	public void setBody(String bodyText){
		body.setText(bodyText);
	}
	
	public String getNumerator(){
		return numerator.getText();
	}
	
	public void setNumerator(String numeratorText){
		numerator.setText(numeratorText);
	}
	
	public String getDenominator(){
		return denominator.getText();
	}
	
	public void setDenominator(String denominatorText){
		denominator.setText(denominatorText);
	}
}
