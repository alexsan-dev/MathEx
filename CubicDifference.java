import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class CubicDifference extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public CubicDifference() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(300, 300);
    setLayout(new GridLayout(5, 1));
    setResizable(true);

    JPanel eq = new JPanel();
    eq.setLayout(new FlowLayout());

    JTextField aField = new JTextField();
    Font frameFont = aField.getFont().deriveFont(20f);
    aField.setFont(frameFont);
    aField.setHorizontalAlignment(SwingConstants.CENTER);
    aField.setPreferredSize(new Dimension(50, 50));

    JLabel title = new JLabel("   Suma y diferencia de cubos");
    title.setFont(title.getFont().deriveFont(15f));
    JLabel text = new JLabel("   Resultado:");
    text.setFont(text.getFont().deriveFont(15f));

    JLabel aLabel = new JLabel("a³");
    aLabel.setFont(frameFont);

    JComboBox<String> sign = new JComboBox<String>();
    sign.setFont(frameFont);
    sign.setAlignmentX(SwingConstants.CENTER);
    sign.addItem("+");
    sign.addItem("-");

    JTextField bField = new JTextField();
    bField.setFont(frameFont);
    bField.setHorizontalAlignment(SwingConstants.CENTER);
    bField.setPreferredSize(new Dimension(50, 50));

    JLabel bLabel = new JLabel("b³");
    bLabel.setFont(frameFont);

    JLabel result = new JLabel();
    result.setHorizontalAlignment(SwingConstants.CENTER);
    result.setVerticalAlignment(SwingConstants.CENTER);
    result.setFont(frameFont);
    result.setOpaque(true);
    result.setBackground(new Color(50, 50, 50));
    result.setForeground(Color.white);

    JButton calculate = new JButton("Calcular");
    calculate.setFont(calculate.getFont().deriveFont(18f));
    calculate.setBackground(new Color(21, 101, 192));
    calculate.setForeground(Color.white);

    eq.add(aField);
    eq.add(aLabel);
    eq.add(sign);
    eq.add(bField);
    eq.add(bLabel);

    add(title);
    add(eq);
    add(text);
    add(result);
    add(calculate);

    calculate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        double a = Double.parseDouble(aField.getText());
        double b = Double.parseDouble(bField.getText());
        double[] r = Maths.cubicDif(a, b);

        result.setText("(" + Maths.parseInt(r[0]) + "a" + sign.getSelectedItem() + Maths.parseInt(r[1]) + "b)" + "("
            + Maths.parseInt(r[2]) + "a² - " + Maths.parseInt(r[3]) + "ab + " + Maths.parseInt(r[4]) + "b²)");
      }
    });
  }
}
