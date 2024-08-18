package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarEmprestimos extends JFrame {
    private JList<String> listEmprestimos;
    private JButton btnVisualizar;

    public ListarEmprestimos() {
        setTitle("Listar Empréstimos");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Empréstimo 1");
        listModel.addElement("Empréstimo 2");
        listModel.addElement("Empréstimo 3");

        listEmprestimos = new JList<>(listModel);
        listEmprestimos.setBounds(10, 10, 260, 100);
        panel.add(listEmprestimos);

        btnVisualizar = new JButton("Visualizar");
        btnVisualizar.setBounds(10, 120, 100, 25);
        panel.add(btnVisualizar);

        btnVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedValue = listEmprestimos.getSelectedValue();
                if (selectedValue != null) {
                    new VisualizarEmprestimo(selectedValue).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um empréstimo para visualizar.");
                }
            }
        });

        add(panel);
    }
}
