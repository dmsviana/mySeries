package views.Canal;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import imagens.Imagens;
import persistencia.CentralDeInformacoes;
import persistencia.Persistencia;
import utils.JButtonPadrao;
import utils.JFramePadrao;
import utils.JLabelPadrao;
import views.TelaHome;

public class TelaCanal extends JFramePadrao{
		
	public TelaCanal() {
			super("mySeries - Canais", 360, 180);
			adicionarImagens();
			adicionarLabels();
			adicionarButtons();
			adicionarSeparador();
			setVisible(true);
		}
	
	private void adicionarImagens() {
		JLabel iconeCanal = new JLabel(Imagens.CANAL_100x100);
		iconeCanal.setBounds(10, 0, 100, 100);
		add(iconeCanal);
	}
	
	private void adicionarLabels() {
		JLabel lblCanal = new JLabelPadrao("Canais", 30, 80, 60, 50);
		add(lblCanal);
	}
	
	private void adicionarButtons() {
		JButton btnCadastrarCanal = new JButtonPadrao("Cadastrar Canal", 125, 15, 200, 30);
		btnCadastrarCanal.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaCadastroCanal();
				
			}
		});
		add(btnCadastrarCanal);
		
		JButton btnListarCanais = new JButtonPadrao("Exibir Canais", 125, 55, 200, 30);
		btnListarCanais.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				Persistencia persistencia = new Persistencia();
				CentralDeInformacoes central = persistencia.recuperarCentral("database.xml");
				
				if(central.getTodosOsCanais().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Oops! Parece que a lista de canais está vazia!", "Aviso!", JOptionPane.WARNING_MESSAGE);
					
				} else {
					dispose();
					new TelaListarCanais();
				}
				
			}
		});
		add(btnListarCanais);
		
		JButton btnVoltar = new JButtonPadrao("Voltar", 125, 95, 200, 30);
		btnVoltar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaHome();
				
			}
		});
		add(btnVoltar);
	}
	
	private void adicionarSeparador() {
		JSeparator separador = new JSeparator(SwingConstants.VERTICAL);
		separador.setBounds(105, 5, 1, 130);
		add(separador);
	}
}
