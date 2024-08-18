package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarUsuario extends JFrame {
    private JTextField txtNome, txtIdade, txtSexo, txtTelefone;
    private JButton btnCadastrar;

    public CadastrarUsuario() {
        setTitle("Cadastrar Usuário");
        setSize(300, 250);
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
        lblIdade.setBounds(10, 40, 80, 25);
        panel.add(lblIdade);

        txtIdade = new JTextField(20);
        txtIdade.setBounds(100, 40, 160, 25);
        panel.add(txtIdade);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(10, 70, 80, 25);
        panel.add(lblSexo);

        txtSexo = new JTextField(20);
        txtSexo.setBounds(100, 70, 160, 25);
        panel.add(txtSexo);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(10, 100, 80, 25);
        panel.add(lblTelefone);

        txtTelefone = new JTextField(20);
        txtTelefone.setBounds(100, 100, 160, 25);
        panel.add(txtTelefone);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(100, 140, 100, 25);
        panel.add(btnCadastrar);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cadastrar o usuário
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            }
        });

        add(panel);
    }
}

