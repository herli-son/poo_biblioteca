package view;

import javax.swing.*;

import Biblioteca.Obras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarAcervo extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<String> listAcervo;
    private JButton btnVisualizar;

    public ListarAcervo() {
        setTitle("Listar Acervo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String item : Obras.Listar()) {
        	listModel.addElement(item);
		}


        listAcervo = new JList<>(listModel);
        listAcervo.setBounds(10, 10, 260, 100);
        panel.add(listAcervo);

        btnVisualizar = new JButton("Visualizar");
        btnVisualizar.setBounds(91, 121, 100, 25);
        panel.add(btnVisualizar);

        btnVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedValue = listAcervo.getSelectedValue();
                if (selectedValue != null) {
                    new VisualizarObra(selectedValue).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma obra para visualizar.");
                }
            }
        });

        getContentPane().add(panel);
    }
}
