package utils;

import java.awt.Font;

import javax.swing.JTextField;

public class JTextFieldPadrao extends JTextField {

	

	public JTextFieldPadrao(int x, int y, int largura, int altura) {
		setBounds(x, y, largura, altura);
		setFont(new Font("Roboto", Font.PLAIN, 14));
		setHorizontalAlignment(JTextField.CENTER);
		
	}
}
