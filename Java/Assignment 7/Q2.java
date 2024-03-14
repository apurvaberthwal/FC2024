import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Q2 extends JFrame {
    private JTextField rollNoField;
    private JTextField nameField;
    private JTable resultTable;

    public Q2() {
        setTitle("Student Result Screen");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel rollNoLabel = new JLabel("Roll No:");
        JLabel nameLabel = new JLabel("Name:");

        rollNoField = new JTextField();
        nameField = new JTextField();

        Object[][] data = {
                { "Sub 1", "", "", "" },
                { "Sub 2", "", "", "" },
                { "Sub 3", "", "", "" },
                { "Sub 4", "", "", "" },
                { "Sub 5", "", "", "" }
        };

        String[] columnNames = { "Sub Name", "CE", "ESE", "Total" };

        resultTable = new JTable(data, columnNames);

        resultTable.setShowGrid(false);
        resultTable.setIntercellSpacing(new Dimension(0, 0));

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JPanel bottomPanel = new JPanel(new BorderLayout());

        topPanel.add(rollNoLabel);
        topPanel.add(rollNoField);
        topPanel.add(nameLabel);
        topPanel.add(nameField);

        JPanel grandTotalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        grandTotalPanel.setBorder(new EmptyBorder(0, 10, 0, 0));
        grandTotalPanel.add(new JLabel("Grand Total: ______  "));

        JPanel gradePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        gradePanel.setBorder(new EmptyBorder(0, 0, 0, 10));
        gradePanel.add(new JLabel("Grade: ______  "));

        bottomPanel.add(grandTotalPanel, BorderLayout.WEST);
        bottomPanel.add(gradePanel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultTable), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Q2();
            }
        });
    }
}
