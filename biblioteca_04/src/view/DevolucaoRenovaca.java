package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DevolucaoRenovaca extends JFrame {
    private JTextField txtUsuario, txtObra;
    private JButton btnDevolver, btnRenovar;

    public DevolucaoRenovaca() {
        setTitle("Devolução/Renovação");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(10, 10, 80, 25);
        panel.add(lblUsuario);

        txtUsuario = new JTextField(20);
        txtUsuario.setBounds(100, 10, 160, 25);
        panel.add(txtUsuario);

        JLabel lblObra = new JLabel("Obra:");
        lblObra.setBounds(10, 40, 80, 25);
        panel.add(lblObra);

        txtObra = new JTextField(20);
        txtObra.setBounds(100, 40, 160, 25);
        panel.add(txtObra);

        btnDevolver = new JButton("Devolver");
        btnDevolver.setBounds(10, 80, 100, 25);
        panel.add(btnDevolver);

        btnRenovar = new JButton("Renovar");
        btnRenovar.setBounds(120, 80, 100, 25);
        panel.add(btnRenovar);

        btnDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para devolver a obra
                JOptionPane.showMessageDialog(null, "Obra devolvida com sucesso!");
            }
        });

        btnRenovar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para renovar a obra
                JOptionPane.showMessageDialog(null, "Obra renovada com sucesso!");
            }
        });

        add(panel);
    }
}
