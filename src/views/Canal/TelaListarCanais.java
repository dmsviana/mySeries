package views.Canal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Canal;
import classes.CanalBroadcastingAberto;
import classes.CanalBroadcastingPago;
import classes.CanalTVAberta;
import classes.CanalTVPago;
import persistencia.CentralDeInformacoes;
import persistencia.Persistencia;
import utils.JButtonPadrao;
import utils.JButtonVoltar;
import utils.JFramePadrao;
import utils.JLabelPadrao;
import utils.JLabelPadraoTitulo;
import utils.RoundedJTextField;

public class TelaListarCanais extends JFramePadrao {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("database.xml");

	private JScrollPane painelTabela;
	private JTable tabelaTodosOsCanais;
	private DefaultTableModel modeloTabela;
	private RoundedJTextField txtBuscar;
	private JButtonPadrao btnExcluir;
	private JButtonPadrao btnEditar;
	private JButtonVoltar btnVoltar;

	public TelaListarCanais() {
		super("mySeries - Listar Canais", 600, 500);
		setVisible(true);
		adicionarLabels();
		adicionarButtons();
		adicionarTabela();
		adicionarTextFields();
	}

	private void adicionarLabels() {
		JLabelPadraoTitulo lblTitulo = new JLabelPadraoTitulo("LISTAGEM DE CANAIS", 190, 10, 200, 28);
		add(lblTitulo);

		JLabelPadrao lblBuscar = new JLabelPadrao("Buscar: ", 100, 80, 60, 30);
		add(lblBuscar);
	}

	private void adicionarButtons() {
		btnEditar = new JButtonPadrao("Editar", 170, 420, 90, 30);
		add(btnEditar);
		
		
		btnExcluir = new JButtonPadrao("Excluir", 360, 420, 90, 30);
			
		
		btnExcluir.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				new TelaExcluirCanal();
				dispose();
				
			}
		});
		
		add(btnExcluir);
	}

	private void adicionarTextFields() {
		txtBuscar = new RoundedJTextField(15, 160, 80, 340, 30);
		add(txtBuscar);
	}

	private DefaultTableModel getModeloTabela() {
		modeloTabela = new DefaultTableModel();
		modeloTabela.addColumn("Nome do canal");
		modeloTabela.addColumn("Numero");
		modeloTabela.addColumn("Mensalidade");
		modeloTabela.addColumn("URL");
		return modeloTabela;
	}

	private void adicionarTabela() {
		modeloTabela = getModeloTabela();
		ArrayList<Canal> todosOsCanais = central.getTodosOsCanais();

		for (Canal canal : todosOsCanais) {
			Object[] linha = new Object[4];
			if (canal instanceof CanalTVAberta) {
				linha[0] = canal.getNomeDoCanal();
				linha[1] = ((CanalTVAberta) canal).getNumeroDoCanal();
				linha[2] = "Não há";
				linha[3] = "Não há";
			} else if (canal instanceof CanalTVPago) {
				linha[0] = canal.getNomeDoCanal();
				linha[1] = "Não há";
				linha[2] = ((CanalTVPago) canal).getMensalidade();
				linha[3] = "Não há";
			} else if (canal instanceof CanalBroadcastingAberto) {
				linha[0] = canal.getNomeDoCanal();
				linha[1] = "Não há";
				linha[2] = "Não há";
				linha[3] = ((CanalBroadcastingAberto) canal).getUrl();;
			} else if (canal instanceof CanalBroadcastingPago) {
				linha[0] = canal.getNomeDoCanal();
				linha[1] = "Não há";
				linha[2] = ((CanalBroadcastingPago) canal).getMensalidade();
				linha[3] = ((CanalBroadcastingPago) canal).getUrl();;
			}
			modeloTabela.addRow(linha);
		}
		tabelaTodosOsCanais = new JTable(modeloTabela);
		tabelaTodosOsCanais.setAutoscrolls(true);
		painelTabela = new JScrollPane(tabelaTodosOsCanais);
		painelTabela.setBounds(60, 120, 480, 280);
		add(painelTabela);
		repaint();

	}
	
	

}
