package utils;

import java.awt.Insets;

import javax.swing.JButton;

import imagens.Imagens;

public class JButtonVoltar extends JButton{
	
	
	public JButtonVoltar() {
		super(Imagens.ICONE_VOLTAR);
		setMargin(new Insets(0, 0, 0, 0));
		setBorder(null);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setToolTipText("Voltar");
	}
	
	
}
