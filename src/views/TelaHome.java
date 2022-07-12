package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import email.Mensageiro;
import imagens.Imagens;
import persistencia.CentralDeInformacoes;
import persistencia.Persistencia;
import relatorios.GeradorDeRelatorios;
import utils.JButtonPadrao;
import utils.JFramePadrao;
import utils.JLabelPadraoTitulo;

public class TelaHome extends JFramePadrao {

	Persistencia persistencia = new Persistencia();

	CentralDeInformacoes central = persistencia.recuperarCentral("database.xml");

	public TelaHome() {
		super("mySeries - Inicio", 400, 400);
		adicionarMenuBar();
		adicionarLabels();
		adicionarImagens();
		adicionarButtons();
		setVisible(true);
	}
	
	
	

	private void adicionarMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("Opções");
		menuBar.add(menu);

		JMenuItem itemSair = new JMenuItem("Sair");
		itemSair.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaLogin();

			}
		});
		
		JMenuItem itemSobre = new JMenuItem("Sobre");
		itemSobre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaSobre();
				
			}
		}); 
		
		
		menu.add(itemSobre);
		menu.add(itemSair);
	}

	private void adicionarLabels() {
		JLabel lblUsuario = new JLabelPadraoTitulo("Seja bem-vindo ao mySeries.", 50, 10, 300, 100);
	
		add(lblUsuario);

	}

	private void adicionarButtons() {
		JButton btnCanais = new JButtonPadrao("Canais", 150, 120, 90, 50);

		btnCanais.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaCanal();

			}
		});
		add(btnCanais);

		JButton btnProgramas = new JButtonPadrao("Programas", 150, 200, 90, 50);
		btnProgramas.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaPrograma();

			}
		});
		add(btnProgramas);

		JButton btnRelatorio = new JButtonPadrao("Relatórios", 150, 290, 90, 50);
		btnRelatorio.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					GeradorDeRelatorios.gerarProgramacaoDeHoje(central);
					Mensageiro.enviarProgramacaoDeHoje("marcello.razer@gmail.com");
				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});
		add(btnRelatorio);
	}

	private void adicionarImagens() {
		JLabel lblLogo = new JLabel(Imagens.NOVO_USER_100x100);
		add(lblLogo);
	}


}
