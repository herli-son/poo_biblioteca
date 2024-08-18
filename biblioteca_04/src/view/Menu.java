package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItemAcervo, menuItemEmprestimos, menuItemReservas;

    public Menu() {
        setTitle("Biblioteca");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        menuBar.add(menu);

        menuItemAcervo = new JMenuItem("Listar Acervo");
        menuItemEmprestimos = new JMenuItem("Listar Empréstimos");
        menuItemReservas = new JMenuItem("Listar Reservas");

        menu.add(menuItemAcervo);
        menu.add(menuItemEmprestimos);
        menu.add(menuItemReservas);

        setJMenuBar(menuBar);

        menuItemAcervo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListarAcervo().setVisible(true);
            }
        });

        menuItemEmprestimos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListarEmprestimos().setVisible(true);
            }
        });

        menuItemReservas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListarReservas().setVisible(true);
            }
        });
    }
}

