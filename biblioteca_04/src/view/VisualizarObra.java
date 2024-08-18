package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizarObra extends JFrame {
    private JLabel lblDetalhes;
    private JButton btnEmprestar;

    public VisualizarObra(String obra) {
        setTitle("Visualizar Obra");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        lblDetalhes = new JLabel("Detalhes da obra: ");
        lblDetalhes.setBounds(10, 10, 260, 25);
        panel.add(lblDetalhes);

        btnEmprestar = new JButton("Emprestar");
        btnEmprestar.setBounds(10, 50, 100, 25);
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