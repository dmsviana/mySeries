package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.ProgramaDeTV;
import classes.Usuario;
import imagens.Imagens;
import persistencia.CentralDeInformacoes;
import persistencia.Persistencia;
import utils.JButtonVoltar;
import utils.JFramePadrao;
import utils.JLabelPadrao;

public class TelaListarProgramas extends JFramePadrao {

	private JTable tblProgramas;
	private JLabel lblTitulo;
	private JButtonVoltar btnVoltar;
	private JScrollPane painelTabela;
	private DefaultTableModel modeloTabela;

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("database.xml");

	public TelaListarProgramas() {
		super("mySeries - Programas", 700, 500);
		setVisible(true);
		adicionarLabels();
		// adicionarMenuBar(usuario);
		adicionarButton();
		adicionarTabela();
	}

	private DefaultTableModel getModeloDaTabela() {
		modeloTabela = new DefaultTableModel();
		modeloTabela.addColumn("Nome do programa: ");
		modeloTabela.addColumn("Tipo do programa: ");
		modeloTabela.addColumn("Dia da semana: ");
		modeloTabela.addColumn("Canal onde é exibido: ");
		return modeloTabela;
	}

	private void adicionarLabels() {
		lblTitulo = new JLabelPadrao("Programas cadastrados", 0, 15, 700, 30);
		add(lblTitulo);
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
//				new TelaPrograma(usuario);
//			}
//		});
//		menu.add(itemSair);
//	}

	private void adicionarTabela() {
		modeloTabela = getModeloDaTabela();

		ArrayList<ProgramaDeTV> todosOsProgramas = central.getTodosOsProgramas();

		for (ProgramaDeTV c : todosOsProgramas) {
			Object[] linha = new Object[4];
			linha[0] = c.getNome();
			linha[1] = c.getTipoDePrograma();
			linha[2] = c.getDiasDaSemana();
			linha[3] = c.getCanal().getNomeDoCanal();
			modeloTabela.addRow(linha);
		}
		tblProgramas = new JTable(modeloTabela);
		tblProgramas.setAutoscrolls(true);
		painelTabela = new JScrollPane(tblProgramas);
		painelTabela.setBounds(0, 100, 685, 500);
		add(painelTabela);
		repaint();
	}

}
