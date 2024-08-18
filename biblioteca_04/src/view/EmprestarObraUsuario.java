package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmprestarObraUsuario extends JFrame {
    private JTextField txtDataEmprestimo;
    private JButton btnEmprestar;

    public EmprestarObraUsuario(String obra) {
        setTitle("Emprestar Obra");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblObra = new JLabel("Obra: " + obra);
        lblObra.setBounds(10, 10, 260, 25);
        panel.add(lblObra);

        JLabel lblDataEmprestimo = new JLabel("Data de Empréstimo:");
        lblDataEmprestimo.setBounds(10, 40, 120, 25);
        panel.add(lblDataEmprestimo);

        txtDataEmprestimo = new JTextField(20);
        txtDataEmprestimo.setBounds(140, 40, 120, 25);
        panel.add(txtDataEmprestimo);

        btnEmprestar = new JButton("Emprestar");
        btnEmprestar.setBounds(100, 80, 100, 25);
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
