package gui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MatrixControl extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JTextField numerator;
	private JTextField denominator;
	private JTextArea body;
	
	public MatrixControl(boolean editable){
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel temp = new JPanel();
		temp.setLayout(new BoxLayout(temp, BoxLayout.Y_AXIS));
		
		numerator = new JTextField(3);
		numerator.setEditable(editable);
		temp.add(numerator);
		temp.add(new JSeparator());
		
		denominator = new JTextField(3);
		denominator.setEditable(editable);
		temp.add(denominator);
		
		add(temp);
		
		body = new JTextArea(6, 30);
		body.setEditable(editable);
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
