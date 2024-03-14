import javax.swing.*;
import java.awt.*;

public class Q3 extends JFrame {

    public Q3() {
        setTitle("Font Families");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontFamilies = ge.getAvailableFontFamilyNames();

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        Font font = new Font("Monospaced", Font.PLAIN, 12);
        textArea.setFont(font);

        for (String fontFamily : fontFamilies) {
            textArea.append(fontFamily + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(textArea);

        add(scrollPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Q3();
            }
        });
    }
}