package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizarReserva extends JFrame {
    private JLabel lblDetalhes;
    private JButton btnCancelar;

    public VisualizarReserva(String reserva) {
        setTitle("Visualizar Reserva");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        lblDetalhes = new JLabel("Detalhes da reserva: " + reserva);
        lblDetalhes.setBounds(10, 10, 260, 25);
        panel.add(lblDetalhes);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(10, 50, 100, 25);
        panel.add(btnCancelar);

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cancelar a reserva
                JOptionPane.showMessageDialog(null, "Reserva cancelada com sucesso!");
            }
        });

        add(panel);
    }
}
