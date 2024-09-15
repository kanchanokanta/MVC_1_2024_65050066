import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private Controller controller;

    public GUI(Controller controller) {
        this.controller = controller;

        setTitle("Cow and Goat ID");
        setSize(800, 500);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Enter Animal ID:");
        JTextField textField = new JTextField(15);
        JButton checkButton = new JButton("Check ID");
        JButton showAllButton = new JButton("Show All Animals");

        inputPanel.add(label);
        inputPanel.add(textField);
        inputPanel.add(checkButton);
        inputPanel.add(showAllButton);

        JTextArea resultArea = new JTextArea(15, 50); 
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textField.getText();
                String result = controller.processGUI(id);
                resultArea.setText(result);
            }
        });

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllAnimalsAndMilk();
            }
        });
    }

    private void showAllAnimalsAndMilk() {
        JFrame allAnimalsFrame = new JFrame("All Animals");
        allAnimalsFrame.setSize(800, 600); 
        allAnimalsFrame.setLocationRelativeTo(null);

        JTextArea allAnimalsArea = new JTextArea(25, 60);
        allAnimalsArea.setEditable(false);

        String allAnimalsData = controller.getAllAnimalsData();
        allAnimalsArea.setText(allAnimalsData);

        allAnimalsFrame.add(new JScrollPane(allAnimalsArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        allAnimalsFrame.setVisible(true);
    }

    public static void main(String[] args) {
        CowView cowView = new CowView();
        GoatView goatView = new GoatView();
        Data dataGen = new Data();
        Controller controller = new Controller(cowView, goatView, dataGen);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI(controller).setVisible(true);
            }
        });
    }
}
