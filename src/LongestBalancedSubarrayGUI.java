import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class LongestBalancedSubarrayGUI extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    public LongestBalancedSubarrayGUI() {
        setTitle("Longest Subarray with Equal 0s and 1s");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel titleLabel = new JLabel("Longest Balanced Binary Subarray Finder", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        JLabel inputLabel = new JLabel(
                "Enter binary array (0s and 1s separated by spaces):",
                JLabel.CENTER
        );
        inputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        inputField = new JTextField();
        inputField.setMaximumSize(new Dimension(300, 35));
        inputField.setPreferredSize(new Dimension(300, 35));
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        inputField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel();
        JButton calculateButton = new JButton("Calculate");
        JButton clearButton = new JButton("Clear");

        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);

        inputPanel.add(inputLabel);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(inputField);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(buttonPanel);

        mainPanel.add(inputPanel, BorderLayout.CENTER);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        outputArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setPreferredSize(new Dimension(650, 250));

        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        calculateButton.addActionListener(e -> processInput());

        clearButton.addActionListener(e -> {
            inputField.setText("");
            outputArea.setText("");
        });

        add(mainPanel);
    }

    private void processInput() {
        try {
            String input = inputField.getText().trim();

            if (input.isEmpty() || !input.contains(" ")) {
                JOptionPane.showMessageDialog(this,
                        "0s and 1s must be separated by space",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String[] parts = input.split(" ");
            int[] nums = new int[parts.length];

            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);

                if (nums[i] != 0 && nums[i] != 1) {
                    throw new IllegalArgumentException("Only 0 and 1 are allowed.");
                }
            }

            int nonRecursiveResult =
                    LongestBalancedSubarray.longestEqualZerosOnesNonRecursive(nums);

            int recursiveResult =
                    LongestBalancedSubarray.longestEqualZerosOnesRecursive(nums);

            StringBuilder result = new StringBuilder();

            result.append("Input Array: ")
                    .append(Arrays.toString(nums))
                    .append("\n\n");

            result.append("Non-Recursive Result: ")
                    .append(nonRecursiveResult)
                    .append("\n");

            result.append("Recursive Result: ")
                    .append(recursiveResult)
                    .append("\n\n");

            if (nonRecursiveResult == recursiveResult) {
                result.append("Both algorithms give the same correct result.");
            } else {
                result.append("There is a mismatch between results.");
            }

            outputArea.setText(result.toString());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers only (0 or 1).",
                    "Format Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new LongestBalancedSubarrayGUI().setVisible(true));
    }
}