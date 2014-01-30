package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CalculatorPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private MatrixControl a = new MatrixControl();
	private MatrixControl b = new MatrixControl();
	private MatrixControl out = new MatrixControl();
	private JTextField scaleField;
	private JTextField iField;
	private JTextField jField;
	
	@SuppressWarnings("unused")
	public CalculatorPanel(){
		
		//set up i/o panels
		io:{
			JPanel ioContainer = new JPanel();
			ioContainer.setLayout(new BoxLayout(ioContainer, BoxLayout.Y_AXIS));
			
			ioContainer.add(Box.createVerticalGlue());
			
			input:{
				JPanel ioPanel = new JPanel();
				ioPanel.add(Box.createHorizontalGlue());
				ioPanel.add(a);
				ioPanel.add(Box.createHorizontalGlue());
				ioPanel.add(b);
				ioPanel.add(Box.createHorizontalGlue());
				ioContainer.add(ioPanel);
			}
			
			ioContainer.add(Box.createVerticalGlue());
			
			output:{
				JPanel ioPanel = new JPanel();
				ioPanel.add(Box.createHorizontalGlue());
				ioPanel.add(out);
				ioPanel.add(Box.createHorizontalGlue());
				ioContainer.add(ioPanel);
			}
			
			ioContainer.add(Box.createVerticalGlue());
		}
		
		controls:{
			JPanel controlPanel = new JPanel();
			controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
			
			unary:{
				JLabel label = new JLabel("<h1>Unary Operations</h1>");
				controlPanel.add(label);
				controlPanel.add(Box.createVerticalGlue());
				
				JButton temp = new JButton("Determinant");
				temp.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//TODO implement all action stuffs
					}
				});
				
				controlPanel.add(temp);
				
				temp = new JButton("Transpose");
				
				temp = new JButton("Inverse");
				
				temp = new JButton("Adjoint");
				
				scale:{
					temp = new JButton("Scale");
				}
				
				minor:{
					temp = new JButton("Minor");
				}
			}
			
			binary:{
				controlPanel.add(Box.createVerticalGlue());
				controlPanel.add(new JSeparator());
				JLabel label = new JLabel("<h1>Binary Operations</h1>");
				controlPanel.add(label);
				controlPanel.add(Box.createVerticalGlue());
				
				
				JButton temp = new JButton("Multiply");
			}
			
			controlPanel.add(Box.createVerticalGlue());
		}
		
	}
}
