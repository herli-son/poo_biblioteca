package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservarObraUsuario extends JFrame {
    private JTextField txtDataReserva;
    private JButton btnReservar;

    public ReservarObraUsuario(String obra) {
        setTitle("Reservar Obra");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblObra = new JLabel("Obra: " + obra);
        lblObra.setBounds(10, 10, 260, 25);
        panel.add(lblObra);

        JLabel lblDataReserva = new JLabel("Data de Reserva:");
        lblDataReserva.setBounds(10, 40, 120, 25);
        panel.add(lblDataReserva);

        txtDataReserva = new JTextField(20);
        txtDataReserva.setBounds(140, 40, 120, 25);
        panel.add(txtDataReserva);

        btnReservar = new JButton("Reservar");
        btnReservar.setBounds(100, 80, 100, 25);
        panel.add(btnReservar);

        btnReservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para reservar a obra
                JOptionPane.showMessageDialog(null, "Obra reservada com sucesso!");
            }
        });

        add(panel);
    }
}
