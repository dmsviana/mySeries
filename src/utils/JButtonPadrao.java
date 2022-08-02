package utils;

import java.awt.Cursor;

import javax.swing.JButton;

import com.itextpdf.text.Font;

public class JButtonPadrao extends JButton{
	
	public JButtonPadrao(String nome, int x, int y, int largura, int altura) {
		setText(nome);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setBounds(x, y, largura, altura);
		setFont(new java.awt.Font("Poppins", 0, 12)); 
	}
	
	
}
