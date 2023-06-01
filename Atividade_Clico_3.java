import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMCCalculator extends JFrame implements ActionListener {
    private JTextField weightField;
    private JTextField heightField;
    private JLabel resultLabel;
    
    public IMCCalculator() {
        setTitle("Calculadora de IMC");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        
        JLabel weightLabel = new JLabel("Peso (Kg):");
        weightField = new JTextField();
        JLabel heightLabel = new JLabel("Altura (Cm):");
        heightField = new JTextField();
        JButton calculateButton = new JButton("Calcular");
        calculateButton.addActionListener(this);
        
        resultLabel = new JLabel();
        
        panel.add(weightLabel);
        panel.add(weightField);
        panel.add(heightLabel);
        panel.add(heightField);
        panel.add(calculateButton);
        panel.add(resultLabel);
        
        add(panel);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Calcular")) {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText()) / 100; // convert cm to m
            
            double bmi = weight / (height * height);
            String classification;
            
            if (bmi < 18.5) {
                classification = "Abaixo do peso";
            } else if (bmi < 25) {
                classification = "Peso normal";
            } else if (bmi < 30) {
                classification = "Sobrepeso";
            } else if (bmi < 35) {
                classification = "Obesidade grau I";
            } else if (bmi < 40) {
                classification = "Obesidade grau II";
            } else {
                classification = "Obesidade grau III";
            }
            
            String result = String.format("IMC: %.2f - %s", bmi, classification);
            resultLabel.setText(result);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new IMCCalculator();
            }
        });
    }
}
