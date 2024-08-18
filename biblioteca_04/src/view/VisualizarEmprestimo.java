package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizarEmprestimo extends JFrame {
    private JLabel lblDetalhes;
    private JButton btnRenovar, btnDevolver;

    public VisualizarEmprestimo(String emprestimo) {
        setTitle("Visualizar Empréstimo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        lblDetalhes = new JLabel("Detalhes do empréstimo: " + emprestimo);
        lblDetalhes.setBounds(10, 10, 260, 25);
        panel.add(lblDetalhes);

        btnRenovar = new JButton("Renovar");
        btnRenovar.setBounds(10, 50, 100, 25);
        panel.add(btnRenovar);

        btnDevolver = new JButton("Devolver");
        btnDevolver.setBounds(120, 50, 100, 25);
        panel.add(btnDevolver);

        btnRenovar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para renovar o empréstimo
                JOptionPane.showMessageDialog(null, "Empréstimo renovado com sucesso!");
            }
        });

        btnDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para devolver o empréstimo
                JOptionPane.showMessageDialog(null, "Empréstimo devolvido com sucesso!");
            }
        });

        add(panel);
    }
}
