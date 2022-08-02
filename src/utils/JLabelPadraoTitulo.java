package utils;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class JLabelPadraoTitulo extends JLabel{
	
	
	public JLabelPadraoTitulo(String nome, int x, int y, int largura, int altura) {
		super(nome);
		setBounds(x, y, largura, altura);
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("Poppins", Font.BOLD, 14));
		setBackground(Color.BLACK);
	}
	
}
