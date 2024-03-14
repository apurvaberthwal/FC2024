import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q5 extends JFrame {
    private JComboBox<String> fontFamilyComboBox;
    private JCheckBox boldCheckBox, italicCheckBox;
    private JTextField helloTextField;
    private JTextField fontSizeField;

    public Q5() {
        setTitle("Font Selection Screen");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel fontLabel = new JLabel("Font:");
        JLabel fontStyleLabel = new JLabel("Font Style:");
        JLabel fontSizeLabel = new JLabel("Font Size:");
        JLabel helloLabel = new JLabel("Hello Everyone");

        String[] fontFamilies = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontFamilyComboBox = new JComboBox<>(fontFamilies);

        boldCheckBox = new JCheckBox("Bold");
        italicCheckBox = new JCheckBox("Italic");

        fontSizeField = new JTextField("12");
        fontSizeField.setColumns(3);

        helloTextField = new JTextField("Hello Everyone");
        helloTextField.setEditable(false);

        JButton applyButton = new JButton("Apply");
        JButton exitButton = new JButton("Exit");

        setLayout(new GridLayout(6, 2, 10, 10));
        // setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        add(fontLabel);
        add(fontFamilyComboBox);
        add(fontSizeLabel);
        add(fontSizeField);
        add(fontStyleLabel);
        add(createFontStylePanel());
        add(helloLabel);
        add(helloTextField);
        add(applyButton);
        add(exitButton);

        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyFontStyles();
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

    private JPanel createFontStylePanel() {
        JPanel fontStylePanel = new JPanel();

        fontStylePanel.add(boldCheckBox);
        fontStylePanel.add(italicCheckBox);

        return fontStylePanel;
    }

    private void applyFontStyles() {
        String fontFamily = (String) fontFamilyComboBox.getSelectedItem();

        int fontStyle = Font.PLAIN;
        if (boldCheckBox.isSelected()) {
            fontStyle |= Font.BOLD;
        }
        if (italicCheckBox.isSelected()) {
            fontStyle |= Font.ITALIC;
        }

        int fontSize;
        try {
            fontSize = Integer.parseInt(fontSizeField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid font size. Enter a valid number.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Font font = new Font(fontFamily, fontStyle, fontSize);
        helloTextField.setFont(font);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Q5();
            }
        });
    }
}
