package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositarTrabalho extends JFrame {
    private JTextField txtTitulo, txtAutor;
    private JButton btnDepositar;

    public DepositarTrabalho() {
        setTitle("Depositar Trabalho");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(10, 10, 80, 25);
        panel.add(lblTitulo);

        txtTitulo = new JTextField(20);
        txtTitulo.setBounds(100, 10, 160, 25);
        panel.add(txtTitulo);

        JLabel lblAutor = new JLabel("Autor:");
        lblAutor.setBounds(10, 40, 80, 25);
        panel.add(lblAutor);

        txtAutor = new JTextField(20);
        txtAutor.setBounds(100, 40, 160, 25);
        panel.add(txtAutor);

        btnDepositar = new JButton("Depositar");
        btnDepositar.setBounds(100, 125, 100, 25);
        panel.add(btnDepositar);

        btnDepositar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para depositar o trabalho
                JOptionPane.showMessageDialog(null, "Trabalho depositado com sucesso!");
            }
        });

        getContentPane().add(panel);
    }
}
