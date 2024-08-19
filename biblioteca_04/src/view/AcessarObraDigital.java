package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcessarObraDigital extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<String> listObrasDigitais;
    private JButton btnAcessar;

    public AcessarObraDigital() {
        setTitle("Acessar Obra Digital");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Obra Digital 1");
        listModel.addElement("Obra Digital 2");
        listModel.addElement("Obra Digital 3");

        listObrasDigitais = new JList<>(listModel);
        listObrasDigitais.setToolTipText("");
        listObrasDigitais.setBounds(10, 10, 260, 100);
        panel.add(listObrasDigitais);

        btnAcessar = new JButton("Acessar");
        btnAcessar.setBounds(10, 120, 100, 25);
        panel.add(btnAcessar);

        btnAcessar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedValue = listObrasDigitais.getSelectedValue();
                if (selectedValue != null) {
                    // Lógica para acessar a obra digital
                    JOptionPane.showMessageDialog(null, "Acessando " + selectedValue);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma obra digital para acessar.");
                }
            }
        });

        getContentPane().add(panel);
    }
}
