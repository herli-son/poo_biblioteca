package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservarObra extends JFrame {
    private JTextField txtUsuario, txtDataReserva;
    private JButton btnReservar;

    public ReservarObra(String obra) {
        setTitle("Reservar Obra");
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

        JLabel lblDataReserva = new JLabel("Data de Reserva:");
        lblDataReserva.setBounds(10, 70, 120, 25);
        panel.add(lblDataReserva);

        txtDataReserva = new JTextField(20);
        txtDataReserva.setBounds(140, 70, 120, 25);
        panel.add(txtDataReserva);

        btnReservar = new JButton("Reservar");
        btnReservar.setBounds(100, 110, 100, 25);
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
