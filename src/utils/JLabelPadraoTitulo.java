package utils;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JLabelPadraoTitulo extends JLabel{
	
	
	public JLabelPadraoTitulo(String nome, int largura, int altura, int x, int y) {
		super(nome);
		setBounds(largura, altura, x, y);
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("Poppins", Font.BOLD, 18));
		setBackground(Color.BLACK);
	}
	
}
