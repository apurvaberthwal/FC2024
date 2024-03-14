import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q4 extends JFrame {
    private JTextField decimalField, binaryField, octalField, hexadecimalField;

    public Q4() {
        setTitle("Number Conversion");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel decimalLabel = new JLabel("Decimal:");
        JLabel binaryLabel = new JLabel("Binary:");
        JLabel octalLabel = new JLabel("Octal:");
        JLabel hexadecimalLabel = new JLabel("Hexadecimal:");

        decimalField = new JTextField();
        binaryField = new JTextField();
        octalField = new JTextField();
        hexadecimalField = new JTextField();

        JButton convertButton = new JButton("Convert");
        JButton exitButton = new JButton("Exit");

        setLayout(new GridLayout(5, 2, 10, 10));

        add(decimalLabel);
        add(decimalField);
        add(binaryLabel);
        add(binaryField);
        add(octalLabel);
        add(octalField);
        add(hexadecimalLabel);
        add(hexadecimalField);
        add(convertButton);
        add(exitButton);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertNumber();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    private void convertNumber() {
        try {
            int decimal = Integer.parseInt(decimalField.getText());

            binaryField.setText(Integer.toBinaryString(decimal));
            octalField.setText(Integer.toOctalString(decimal));
            hexadecimalField.setText(Integer.toHexString(decimal));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid. Enter a valid decimal number.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Q4();
            }
        });
    }
}
