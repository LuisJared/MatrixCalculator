package gui;

import javax.swing.JFrame;

public class MainGui extends JFrame{
	private static final long serialVersionUID = 1L;

	public MainGui(){
		add(new CalculatorPanel());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
