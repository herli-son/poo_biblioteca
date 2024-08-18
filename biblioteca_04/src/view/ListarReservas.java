package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarReservas extends JFrame {
    private JList<String> listReservas;
    private JButton btnVisualizar;

    public ListarReservas() {
        setTitle("Listar Reservas");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Reserva 1");
        listModel.addElement("Reserva 2");
        listModel.addElement("Reserva 3");

        listReservas = new JList<>(listModel);
        listReservas.setBounds(10, 10, 260, 100);
        panel.add(listReservas);

        btnVisualizar = new JButton("Visualizar");
        btnVisualizar.setBounds(10, 120, 100, 25);
        panel.add(btnVisualizar);

        btnVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedValue = listReservas.getSelectedValue();
                if (selectedValue != null) {
                    new VisualizarReserva(selectedValue).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma reserva para visualizar.");
                }
            }
        });

        add(panel);
    }
}
