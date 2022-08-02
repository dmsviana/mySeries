package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.text.MaskFormatter;

import classes.Usuario;
import imagens.Imagens;
import persistencia.CentralDeInformacoes;
import persistencia.Persistencia;
import utils.JButtonPadrao;
import utils.JButtonVoltar;
import utils.JFramePadrao;
import utils.JLabelPadrao;
import utils.JLabelPadraoTitulo;
import utils.JTextFieldPadrao;

public class TelaCadastroUsuario extends JFramePadrao {


    private JTextFieldPadrao txtNome;
    private JTextFieldPadrao txtEmail;
    private JFormattedTextField txtData;
    private JFormattedTextField txtTelefone;
    private JPasswordField txtSenha;
    private JPasswordField txtConfirmarSenha;

    Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("database.xml");
    
    
    
    public TelaCadastroUsuario() {
        super("mySeries - Cadastro Usuario", 533, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        adicionarLabels();
        adicionarTextFields();
        adicionarButtons();
        repaint();
    }

    private void adicionarLabels() {
        JLabelPadraoTitulo lblTitulo = new JLabelPadraoTitulo("CADASTRO USUARIO", 170, 20, 150, 30);
        add(lblTitulo);

        JLabelPadrao lblNome = new JLabelPadrao("Nome: ", 50, 70, 50, 20);
        add(lblNome);

        JLabelPadrao lblTelefone = new JLabelPadrao("Telefone: ", 320, 140, 70, 20);
        add(lblTelefone);


        JLabelPadrao lblData = new JLabelPadrao("Data de nascimento: ", 330, 70, 130, 20);
        add(lblData);

        JLabelPadrao lblEmail = new JLabelPadrao("Email: ", 50, 140, 50, 20);
        add(lblEmail);

        JLabelPadrao lblSenha = new JLabelPadrao("Senha: ", 50, 210, 50, 20);
        add(lblSenha);

        JLabelPadrao lblConfirmarSenha = new JLabelPadrao("Confirmar Senha: ", 325, 210, 120, 20);
        add(lblConfirmarSenha);
    }

    private void adicionarTextFields(){
        txtNome = new JTextFieldPadrao(50, 90, 130, 30);
        add(txtNome);

        try {
            MaskFormatter maskData = new MaskFormatter("##/##/####");

            txtData = new JFormattedTextField(maskData);
            txtData.setBounds(330, 90, 130, 30);
            add(txtData);

            MaskFormatter maskTelefone = new MaskFormatter("(##) #####-####");
            txtTelefone = new JFormattedTextField(maskTelefone);
        txtTelefone.setBounds(330, 160, 130, 30);
        add(txtTelefone);
        } catch (Exception e){
            e.printStackTrace();
        }


        txtEmail = new JTextFieldPadrao(50, 160, 130, 30);
        add(txtEmail);

        

        txtSenha = new JPasswordField();
        txtSenha.setBounds(50, 230, 130, 30);
        add(txtSenha);

         txtConfirmarSenha = new JPasswordField();
        txtConfirmarSenha.setBounds(330, 230, 130, 30);
        add(txtConfirmarSenha);

    }

    private void adicionarButtons(){
        JButtonPadrao btnCadastrar = new JButtonPadrao("Cadastar", 200, 300, 100, 30);
        
        btnCadastrar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				if(txtNome.getText().isEmpty() 
						|| txtEmail.getText().isEmpty() 
						|| txtTelefone.getText().isEmpty() 
						|| txtData.getText().isEmpty() || txtSenha.getPassword().length == 0 
						|| txtConfirmarSenha.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Preencha todos os dados!", "ATENÇÃO!",
							JOptionPane.WARNING_MESSAGE);
				} else if (!(new String(txtSenha.getPassword()).equals(new String(txtConfirmarSenha.getPassword())))) {
					JOptionPane.showMessageDialog(null, "Senhas diferentes!", "ATENÇÃO!", JOptionPane.ERROR_MESSAGE, Imagens.ICONE_ERRO);
					txtSenha.setText("");
					txtConfirmarSenha.setText("");
					repaint();
				} else if (new String(txtSenha.getPassword()).length() < 5) {
					JOptionPane.showMessageDialog(null,
							"Sua senha é muito curta! Tente uma senha com mais de 6 caracteres!", "ATENÇÃO!",
							JOptionPane.WARNING_MESSAGE, Imagens.ICONE_ERRO);
					txtSenha.setText("");
					txtConfirmarSenha.setText("");
				} else {
					Usuario novoUsuario = null;
					Date dataDeNascimento = null;
					try {
						SimpleDateFormat formatoDataDeNascimento = new SimpleDateFormat("dd/MM/yyyy");
						formatoDataDeNascimento.setLenient(false);
						dataDeNascimento = formatoDataDeNascimento.parse(txtData.getText());
					} catch (Exception erro) {
						JOptionPane.showMessageDialog(null, "Data de nascimento inválida!", "ATENÇÃO!",
								JOptionPane.ERROR_MESSAGE, Imagens.ICONE_ERRO);
						txtData.setText("");
						return;
					}
					novoUsuario = new Usuario(txtNome.getText(), txtTelefone.getText(), dataDeNascimento, txtEmail.getText(), new String(txtSenha.getPassword()));					
					
					for(Usuario usuario : central.getTodosOsUsuarios()) {
						if(usuario.getEmail().equals(txtEmail.getText())) {
							JOptionPane.showMessageDialog(null, "Usuário já existe!", "Atenção!",
									JOptionPane.ERROR_MESSAGE);
						} else {
							
						}
					}
					
					try {
						central.adicionarUsuario(novoUsuario);
						JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!", "Nova conta",
								JOptionPane.INFORMATION_MESSAGE, Imagens.ICONE_CHECK);
						persistencia.salvarCentral(central, "database.xml");
						dispose();
						System.out.println(novoUsuario.toString());
						new TelaLogin();
						
					} catch(Exception erro) {
						JOptionPane.showMessageDialog(null, erro.getMessage(), "ATENÇÃO!", JOptionPane.WARNING_MESSAGE, Imagens.ICONE_ERRO);
					}
				}
				
				
				
				
			}
		});
        
        add(btnCadastrar);



        JButtonVoltar btnVoltar = new JButtonVoltar();
        btnVoltar.setBounds(30, 10, 24, 24);
        add(btnVoltar);


    }



    }


    


    

