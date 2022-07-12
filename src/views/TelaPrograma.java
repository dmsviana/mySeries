package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import classes.Usuario;
import imagens.Imagens;
import persistencia.CentralDeInformacoes;
import persistencia.Persistencia;
import utils.JButtonPadrao;
import utils.JFramePadrao;
import utils.JLabelPadrao;

public class TelaPrograma extends JFramePadrao {

	public TelaPrograma() {
		super("mySeries - Programas", 360, 180);
		adicionarImagens();
		adicionarLabels();
		adicionarButtons();
		adicionarSeparador();
		setVisible(true);
		
	}
	
	
	private void adicionarImagens() {
		JLabel iconePrograma = new JLabel(Imagens.ICONE_PROGRAMA);
		iconePrograma.setBounds(20, 20, 64, 64);
		add(iconePrograma);
	}
	
	private void adicionarLabels() {
		JLabel lblPrograma = new JLabelPadrao("Programas", 10, 75, 90, 50);
		add(lblPrograma);
	}
	
	private void adicionarButtons() {
		JButton btnCadastrarPrograma = new JButtonPadrao("Cadastrar programa", 125, 15, 200, 30);
		btnCadastrarPrograma.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Em breve");
				
			}
		});
		add(btnCadastrarPrograma);
		
		JButton btnListarProgramas = new JButtonPadrao("Exibir Programas", 125, 55, 200, 30);
		btnListarProgramas.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				Persistencia persistencia = new Persistencia();
				CentralDeInformacoes central = persistencia.recuperarCentral("database.xml");
				
				if(central.getTodosOsProgramas().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Oops! Parece que a lista de programas está vazia!", "Aviso!", JOptionPane.WARNING_MESSAGE);
					
				} else {
					dispose();
					new TelaListarProgramas();
				}
				
			}
		});
		add(btnListarProgramas);
		
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
		separador.setForeground(Color.GRAY);
		add(separador);
	}
	
	

}
