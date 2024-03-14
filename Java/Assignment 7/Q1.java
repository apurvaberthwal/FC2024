import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q1 extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Q1() {
        setTitle("Login Screen");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Submit");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        setLayout(new GridLayout(3, 2, 10, 10));

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(loginButton);
        buttonPanel.add(cancelButton);
        add(new JLabel());
        add(buttonPanel);
        setVisible(true);
    }

    private void login() {
        String username = usernameField.getText();
        char[] password = passwordField.getPassword();
        if (username.equals(String.valueOf(password))) {
            JOptionPane.showMessageDialog(this, "Correct Login Details");
        } else {
            JOptionPane.showMessageDialog(this, "Wrong Details", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Q1();
            }
        });
    }
}
