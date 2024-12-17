import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatePropertyTax extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField propertyValueField;
    private JLabel assessmentLabel;
    private JLabel taxLabel;
    private JButton calculateButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CalculatePropertyTax frame = new CalculatePropertyTax();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CalculatePropertyTax() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 300);
        setTitle("Property Tax Calculator");

        // Create content pane with a light green background
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 255, 204)); // Light green
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        // Layout manager for content pane
        GridBagLayout layout = new GridBagLayout();
        contentPane.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        // Set the font and create labels and input fields
        JLabel propertyValueLabel = new JLabel("Enter Property Value ($): ");
        propertyValueLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        propertyValueField = new JTextField();
        propertyValueField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        propertyValueField.setColumns(10);
        propertyValueField.setBackground(Color.WHITE);
        propertyValueField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        assessmentLabel = new JLabel("Assessment Value: ");
        assessmentLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));

        taxLabel = new JLabel("Property Tax: ");
        taxLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));

        // Create the calculate button with flat design
        calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        calculateButton.setBackground(new Color(0, 123, 255)); // Bootstrap blue
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setFocusPainted(false);
        calculateButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        calculateButton.setOpaque(true);

        // Add action listener to calculate tax
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTax();
            }
        });

        // Set the layout constraints for each component
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 20, 10, 20); // More horizontal space
        contentPane.add(propertyValueLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 2;
        contentPane.add(propertyValueField, gbc);

        gbc.gridy = 2;
        gbc.gridwidth = 2;
        contentPane.add(calculateButton, gbc);

        gbc.gridy = 3;
        gbc.gridwidth = 2;
        contentPane.add(assessmentLabel, gbc);

        gbc.gridy = 4;
        gbc.gridwidth = 2;
        contentPane.add(taxLabel, gbc);
    }

    /**
     * Calculate the property tax and update the labels
     */
    private void calculateTax() {
        try {
            // Parse property value and calculate
            double propertyValue = Double.parseDouble(propertyValueField.getText());
            double assessmentValue = propertyValue * 0.60;
            double propertyTax = (assessmentValue / 100) * 0.64;

            // Update the labels with the results
            assessmentLabel.setText(String.format("Assessment Value: $%.2f", assessmentValue));
            taxLabel.setText(String.format("Property Tax: $%.2f", propertyTax));
        } catch (NumberFormatException ex) {
            // Display an error message if the input is invalid
            JOptionPane.showMessageDialog(this, "Please enter a valid property value!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
