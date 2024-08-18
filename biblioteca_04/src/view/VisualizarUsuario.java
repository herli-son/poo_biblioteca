package view;

import javax.swing.*;

public class VisualizarUsuario extends JFrame {
    private JLabel lblDetalhes;

    public VisualizarUsuario(String usuario) {
        setTitle("Visualizar Usuário");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        lblDetalhes = new JLabel("Detalhes do usuário: " );
        lblDetalhes.setBounds(10, 10, 260, 25);
        panel.add(lblDetalhes);

        add(panel);
    }
}
