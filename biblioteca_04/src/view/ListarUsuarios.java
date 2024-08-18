package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarUsuarios extends JFrame {
    private JList<String> listUsuarios;
    private JButton btnVisualizar, btnCadastrar, btnEditar, btnExcluir;

    public ListarUsuarios() {
        setTitle("Listar Usuários");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Usuário 1");
        listModel.addElement("Usuário 2");
        listModel.addElement("Usuário 3");

        listUsuarios = new JList<>(listModel);
        listUsuarios.setBounds(10, 10, 260, 200);
        panel.add(listUsuarios);

        btnVisualizar = new JButton("Visualizar");
        btnVisualizar.setBounds(280, 10, 100, 25);
        panel.add(btnVisualizar);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(280, 50, 100, 25);
        panel.add(btnCadastrar);

        btnEditar = new JButton("Editar");
        btnEditar.setBounds(280, 90, 100, 25);
        panel.add(btnEditar);

        btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(280, 130, 100, 25);
        panel.add(btnExcluir);

        btnVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedValue = listUsuarios.getSelectedValue();
                if (selectedValue != null) {
                    new VisualizarUsuario(selectedValue).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um usuário para visualizar.");
                }
            }
        });

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastrarUsuario().setVisible(true);
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedValue = listUsuarios.getSelectedValue();
                if (selectedValue != null) {
                    new EditarUsuario(selectedValue).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um usuário para editar.");
                }
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedValue = listUsuarios.getSelectedValue();
                if (selectedValue != null) {
                    // Lógica para excluir o usuário
                    listModel.removeElement(selectedValue);
                    JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um usuário para excluir.");
                }
            }
        });

        add(panel);
    }
}
