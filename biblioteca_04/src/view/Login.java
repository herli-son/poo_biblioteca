package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnLogin;

    public Login() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(10, 10, 80, 25);
        panel.add(lblUsuario);

        txtUsuario = new JTextField(20);
        txtUsuario.setBounds(100, 10, 160, 25);
        panel.add(txtUsuario);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(10, 40, 80, 25);
        panel.add(lblSenha);

        txtSenha = new JPasswordField(20);
        txtSenha.setBounds(100, 40, 160, 25);
        panel.add(txtSenha);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(100, 80, 80, 25);
        panel.add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica de autenticação
                String usuario = txtUsuario.getText();
                String senha = new String(txtSenha.getPassword());

                if (usuario.equals("admin") && senha.equals("admin")) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                    // Abrir a próxima tela
                    new Menu().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos.");
                }
            }
        });

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}

