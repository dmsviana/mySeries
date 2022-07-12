package utils;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JLabelPadrao extends JLabel{
	
	public JLabelPadrao(String nome, int largura, int altura, int x, int y) {
		super(nome);
		setBounds(largura, altura, x, y);
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("Poppins", Font.PLAIN, 14));
		setBackground(Color.BLACK);
	}
	
	
	
	
	
	
	
}
