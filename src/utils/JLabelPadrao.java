package utils;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JLabelPadrao extends JLabel{
	
	public JLabelPadrao(String nome, int x, int y, int largura, int altura) {
		super(nome);
		setBounds(x, y, largura, altura);
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("Poppins", Font.PLAIN, 12));
		setBackground(Color.BLACK);
	}
	
	
	
	
	
	
	
}
