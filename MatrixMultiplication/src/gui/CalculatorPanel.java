package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import math.Calculator;

public class CalculatorPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private MatrixControl a = new MatrixControl(true);
	private MatrixControl b = new MatrixControl(true);
	private MatrixControl out = new MatrixControl(false);
	private JTextField scaleField = new JTextField(3);
	private JTextField iField = new JTextField(3);
	private JTextField jField =  new JTextField(3);

	@SuppressWarnings("unused")
	public CalculatorPanel(){

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

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

			add(ioContainer);
		}

		controls:{
			JPanel controlPanel = new JPanel();
			controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

			unary:{
				JLabel label = new JLabel("Unary Operations");
				controlPanel.add(label);
				controlPanel.add(Box.createVerticalGlue());

				JButton temp = new JButton("Determinant");
				temp.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						try{
							out.setNumerator(""+Calculator.determinant(stringToMatrix(a.getBody())));
						}catch(Exception ex){
							displayError(ex.getMessage());
							return;
						}
						out.setDenominator("");
						out.setBody("");
					}
				});
				controlPanel.add(temp);

				temp = new JButton("Transpose");
				temp.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						try{
							out.setBody(matrixToString(Calculator.transpose(stringToMatrix(a.getBody()))));
						}catch(Exception ex){
							displayError(ex.getMessage());
							return;
						}

						out.setNumerator("");
						out.setDenominator("");

					}
				});
				controlPanel.add(temp);

				temp = new JButton("Inverse");
				temp.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						out.setNumerator("1");

						int[][] matrix = null;

						try{
							matrix = stringToMatrix(a.getBody());
						}catch(Exception ex){
							displayError(ex.getMessage());
							return;
						}

						out.setDenominator("" + Calculator.determinant(matrix));
						out.setBody(matrixToString(Calculator.invertBody(matrix)));
					}
				});
				controlPanel.add(temp);

				temp = new JButton("Adjoint");
				temp.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						try{
							out.setBody(matrixToString(Calculator.adjoint(stringToMatrix(a.getBody()))));
						}catch(Exception ex){
							displayError(ex.getMessage());
							return;
						}
						out.setNumerator("");
						out.setDenominator("");
					}
				});
				controlPanel.add(temp);

				scale:{
					JPanel tempPanel = new JPanel();
					tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.X_AXIS));

					temp = new JButton("Scale");
					temp.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							try{
								int scale = Integer.parseInt(scaleField.getText());
								int[][] matrix = null;


								try{
									matrix = stringToMatrix(a.getBody());
								}catch(Exception ex){
									displayError(ex.getMessage());
									return;
								}

								Calculator.multiply(matrix, scale);

								out.setNumerator("");
								out.setDenominator("");
								out.setBody(matrixToString(matrix));
							}catch(NumberFormatException ex){
								displayError("Scale must be an integer.");
							}
						}
					});
					tempPanel.add(temp);

					tempPanel.add(Box.createHorizontalStrut(30));
					tempPanel.add(new JLabel("Scale:"));
					tempPanel.add(Box.createHorizontalStrut(10));
					tempPanel.add(scaleField);

					controlPanel.add(tempPanel);
				}

				minor:{
					JPanel tempPanel = new JPanel();
					tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.X_AXIS));

					temp = new JButton("Minor");
					temp.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							int i = 0;
							int j = 0;
							try{
								i = Integer.parseInt(iField.getText());
							}catch(NumberFormatException ex){
								displayError("i must be an integer");
								return;
							}
							try{
								j = Integer.parseInt(jField.getText());
							}catch(NumberFormatException ex){
								displayError("j must be an integer");
								return;
							}

							int[][] matrix = null;

							try{
								matrix = stringToMatrix(a.getBody());
							}catch(Exception ex){
								displayError(ex.getMessage());
								return;
							}

							if(i >= matrix.length){
								displayError("i must be less than the length (" + matrix.length + ") of the matrix. Remember that this program is 0 indexed.");
								return;
							}

							if(i >= matrix.length){
								displayError("j must be less than the length (" + matrix.length + ") of the matrix. Remember that this program is 0 indexed.");
								return;
							}

							out.setNumerator("");
							out.setDenominator("");
							out.setBody(matrixToString(Calculator.minor(matrix, i, j)));
						}
					});
					tempPanel.add(temp);

					tempPanel.add(Box.createHorizontalStrut(30));
					tempPanel.add(new JLabel("i:"));
					tempPanel.add(Box.createHorizontalStrut(10));
					tempPanel.add(iField);
					tempPanel.add(Box.createHorizontalStrut(30));
					tempPanel.add(new JLabel("j:"));
					tempPanel.add(Box.createHorizontalStrut(10));
					tempPanel.add(jField);

					controlPanel.add(tempPanel);
				}
			}

			binary:{
				controlPanel.add(Box.createVerticalGlue());
				controlPanel.add(new JSeparator());
				JLabel label = new JLabel("Binary Operations");
				controlPanel.add(label);
				controlPanel.add(Box.createVerticalGlue());


				JButton temp = new JButton("Multiply");
				temp.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						try{
							out.setBody(matrixToString(Calculator.multiply(stringToMatrix(a.getBody()), stringToMatrix(b.getBody()))));
						}catch(Exception ex){
							displayError(ex.getMessage());
							return;
						}
						
						out.setNumerator("");
						out.setDenominator("");

					}
				});
				controlPanel.add(temp);
			}

			controlPanel.add(Box.createVerticalGlue());

			add(controlPanel);
		}
	}

	//TODO implement
	private int[][] stringToMatrix(String s){
		return Converter.convertBody(s);
	}

	//TODO implement
	private String matrixToString(int[][] matrix){
		return Converter.convertBody(matrix);
	}

	private void displayError(String message){
		JOptionPane.showMessageDialog(null, message);
	}
}
