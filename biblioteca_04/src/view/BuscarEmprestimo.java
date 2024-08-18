package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarEmprestimo extends JFrame {
	private JTextField txtBusca;
	private JButton btnBuscar;

	public BuscarEmprestimo() {
		setTitle("Buscar Empréstimo");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		JLabel lblBusca = new JLabel("Buscar Empréstimo:");
		lblBusca.setBounds(10, 10, 120, 25);
		panel.add(lblBusca);

		txtBusca = new JTextField(20);
		txtBusca.setBounds(110, 10, 130, 25);
		panel.add(txtBusca);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(100, 75, 80, 25);
		panel.add(btnBuscar);

		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String busca = txtBusca.getText();
				// Lógica para buscar o empréstimo
				new VisualizarEmprestimo(busca).setVisible(true);
			}
		});

		getContentPane().add(panel);
	}
}
