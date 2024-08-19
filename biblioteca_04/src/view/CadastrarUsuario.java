package view;

import javax.swing.*;

import Biblioteca.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarUsuario extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNome, txtIdade, txtSexo, txtTelefone;
    private JButton btnCadastrar;
    private JTextField txtAcesso;
    private JPasswordField txtSenha;

    public CadastrarUsuario() {
        setTitle("Cadastrar Usuário");
        setSize(300, 354);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 10, 80, 25);
        panel.add(lblNome);

        txtNome = new JTextField(20);
        txtNome.setBounds(100, 10, 160, 25);
        panel.add(txtNome);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(10, 46, 80, 25);
        panel.add(lblIdade);

        txtIdade = new JTextField(20);
        txtIdade.setBounds(100, 46, 160, 25);
        panel.add(txtIdade);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(10, 82, 80, 25);
        panel.add(lblSexo);

        txtSexo = new JTextField(20);
        txtSexo.setBounds(100, 82, 160, 25);
        panel.add(txtSexo);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(10, 118, 80, 25);
        panel.add(lblTelefone);

        txtTelefone = new JTextField(20);
        txtTelefone.setBounds(100, 118, 160, 25);
        panel.add(txtTelefone);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(100, 279, 100, 25);
        panel.add(btnCadastrar);

        txtAcesso = new JTextField(20);
        txtAcesso.setBounds(100, 154, 160, 25);
        panel.add(txtAcesso);
        
        JLabel lblAcesso = new JLabel("Acesso:");
        lblAcesso.setBounds(10, 154, 80, 25);
        panel.add(lblAcesso);
        
        txtSenha = new JPasswordField();
        txtSenha.setBounds(100, 189, 160, 25);
        panel.add(txtSenha);
        
        JLabel lblPassword = new JLabel("Senha:");
        lblPassword.setBounds(10, 194, 46, 14);
        panel.add(lblPassword);
        

        getContentPane().add(panel);
        
        JComboBox<?> tipo = new JComboBox();
        tipo.setModel(new DefaultComboBoxModel(new String[] {"Aluno", "Professor", "Funcionario"}));
        tipo.setBounds(100, 225, 160, 22);
        panel.add(tipo);
        
        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(10, 229, 46, 14);
        panel.add(lblTipo);
        
        btnCadastrar.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// Lógica para cadastrar o usuário
        		Main.CadastrarUsuario(txtNome.getText(), txtIdade.getText(), txtSexo.getText(), txtTelefone.getText(), txtAcesso.getText(), txtSenha.getText(), tipo.getSelectedIndex() );
        		JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        	}
        });
    }
}

