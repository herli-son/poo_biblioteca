package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmprestarObra extends JFrame {
    private JTextField txtUsuario, txtDataEmprestimo;
    private JButton btnEmprestar;

    public EmprestarObra(String obra) {
        setTitle("Emprestar Obra");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblObra = new JLabel("Obra: " + obra);
        lblObra.setBounds(10, 10, 260, 25);
        panel.add(lblObra);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(10, 40, 80, 25);
        panel.add(lblUsuario);

        txtUsuario = new JTextField(20);
        txtUsuario.setBounds(100, 40, 160, 25);
        panel.add(txtUsuario);

        JLabel lblDataEmprestimo = new JLabel("Data de Empréstimo:");
        lblDataEmprestimo.setBounds(10, 70, 120, 25);
        panel.add(lblDataEmprestimo);

        txtDataEmprestimo = new JTextField(20);
        txtDataEmprestimo.setBounds(140, 70, 120, 25);
        panel.add(txtDataEmprestimo);

        btnEmprestar = new JButton("Emprestar");
        btnEmprestar.setBounds(100, 110, 100, 25);
        panel.add(btnEmprestar);

        btnEmprestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para emprestar a obra
                JOptionPane.showMessageDialog(null, "Obra emprestada com sucesso!");
            }
        });

        add(panel);
    }
}
