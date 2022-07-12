package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Canal;
import classes.Usuario;
import imagens.Imagens;
import persistencia.CentralDeInformacoes;
import persistencia.Persistencia;
import utils.JButtonVoltar;
import utils.JFramePadrao;
import utils.JLabelPadrao;

public class TelaListarCanais extends JFramePadrao{
	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("database.xml");
	
	private JTable tblCanais;
	private JLabel lblTitulo;
	private JScrollPane painelTabela;
	private DefaultTableModel modeloTabela;
	
	public TelaListarCanais() {
		super("Canal - Todos os canais", 700, 500);
		adicionarLabels();
		//adicionarMenuBar(usuario);
		adicionarTabela();
		adicionarButton();
		setVisible(true);
	}
	
	private void adicionarButton() {
		
		JButtonVoltar btnVoltar = new JButtonVoltar();
		btnVoltar.setBounds(10, 11, 34, 36);
		
		btnVoltar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaCanal();
				
			}
		});
		
		add(btnVoltar);
		
	}
	
	
	private DefaultTableModel getModeloDaTabela() {
		modeloTabela = new DefaultTableModel();
		modeloTabela.addColumn("Nome do canal: ");
		modeloTabela.addColumn("Tipo do canal: ");
		return modeloTabela;
	}
	
	private void adicionarLabels() {
		lblTitulo = new JLabelPadrao("Canais cadastrados", 0, 15, 700, 30);
		add(lblTitulo);
	}
	
//	private void adicionarMenuBar(Usuario usuario) {
//		JMenuBar menuBar = new JMenuBar();
//		setJMenuBar(menuBar);
//		
//		JMenu menu = new JMenu("Opções");
//		menuBar.add(menu);
//		
//		JMenuItem itemSair = new JMenuItem("Voltar");
//		itemSair.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//				new TelaCanal(usuario);
//			}
//		});
//		menu.add(itemSair);
//	}
	
	private void adicionarTabela() {
		modeloTabela = getModeloDaTabela();
		
		ArrayList<Canal> todosOsCanais = central.getTodosOsCanais();
		
		for(Canal c : todosOsCanais) {
			Object[] linha = new Object[2];
			linha[0] = c.getNomeDoCanal();
			linha[1] = c.getTipoDoCanal();
			modeloTabela.addRow(linha);
		}
		tblCanais = new JTable(modeloTabela);
		tblCanais.setAutoscrolls(true);
		painelTabela = new JScrollPane(tblCanais);
		painelTabela.setBounds(0, 100, 685, 500);
		add(painelTabela);
		repaint();
	}

}
