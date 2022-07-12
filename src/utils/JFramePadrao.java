package utils;

import javax.swing.JFrame;

public abstract class JFramePadrao extends JFrame {
	public JFramePadrao(String titulo, int largura, int altura) {
		setSize(largura, altura);
		setTitle(titulo);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		//setIconImage(Imagens.ICONE_PROGRAMA.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JFramePadrao() {
		
	}
}
