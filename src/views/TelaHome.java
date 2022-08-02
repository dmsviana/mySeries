package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import imagens.Imagens;
import utils.JButtonPadrao;
import utils.JFramePadrao;
import utils.JLabelPadraoTitulo;
import views.Canal.TelaCanal;
import views.Programa.TelaPrograma;

public class TelaHome extends JFramePadrao{
    

    private JButtonPadrao btnCanais;
    private JButtonPadrao btnProgramas;
    private JButtonPadrao btnRelatorios;
    


    public TelaHome(){
        super("mySeries - Inicio", 500, 200);
        adicionarLabels();
        adicionarButtons();
        adicionarSeparador();
        setVisible(true);
    }


    private void adicionarLabels(){
        JLabel lblLogo = new JLabel(Imagens.LOGO_MY_SERIES_250x250);
        lblLogo.setBounds(0, 10, 110, 130);

        JLabelPadraoTitulo lblTitulo = new JLabelPadraoTitulo("Bem-vindo ao mySeries", 180, 20, 230, 28);

        add(lblLogo);
        add(lblTitulo);
    }

    private void adicionarButtons(){
        btnCanais = new JButtonPadrao("Canais", 130, 70, 90, 50);
        btnCanais.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaCanal();

			}
		});
		add(btnCanais);
        
        btnProgramas = new JButtonPadrao("Programas", 250, 70, 100, 50);
        btnProgramas.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaPrograma();

			}
		});
        
        btnRelatorios = new JButtonPadrao("Relatorios", 380, 70, 90, 50);
        add(btnCanais);

        add(btnProgramas);
        add(btnRelatorios);
    }

    private void adicionarSeparador(){
        JSeparator separador = new JSeparator(SwingConstants.VERTICAL);
        separador.setBounds(110, 0, 10, 160);
        add(separador);
    }


    

}
