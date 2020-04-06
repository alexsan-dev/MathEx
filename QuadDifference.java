import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class QuadDifference extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public QuadDifference() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(300, 300);
    setLayout(new GridLayout(5, 1));
    setResizable(true);

    // COMPONENTES

    JTextField a2 = new JTextField();
    Font font = a2.getFont().deriveFont(20f);
    a2.setFont(font);
    a2.setHorizontalAlignment(SwingConstants.CENTER);
    a2.setPreferredSize(new Dimension(50, 50));

    JLabel a2f = new JLabel("a² - ");
 a2f.setFont(font);

    JTextField b2 = new JTextField();
    b2.setFont(font);
    b2.setHorizontalAlignment(SwingConstants.CENTER);
    b2.setPreferredSize(new Dimension(50, 50));

    JLabel b2f = new JLabel("b²");
    b2f.setFont(font);

    JLabel title = new JLabel("   Diferencia de cuadrados");
    title.setFont(title.getFont().deriveFont(15f));
    JLabel text = new JLabel("   Resultado:");
    text.setFont(text.getFont().deriveFont(15f));

    JLabel compose = new JLabel("(a - b)(a + b)");
    compose.setHorizontalAlignment(SwingConstants.CENTER);
    compose.setVerticalAlignment(SwingConstants.CENTER);
    compose.setFont(font);
    compose.setOpaque(true);
    compose.setBackground(new Color(50, 50, 50));
    compose.setForeground(Color.white);

    JPanel mainline = new JPanel();
    mainline.setLayout(new FlowLayout());

    JButton calculate = new JButton("Calcular");
    calculate.setFont(calculate.getFont().deriveFont(18f));
    calculate.setBackground(new Color(21, 101, 192));
        calculate.setForeground(Color.white);

    mainline.add(a2);
    mainline.add(a2f);
    mainline.add(b2);
    mainline.add(b2f);

    add(title);
    add(mainline);
    add(text);
    add(compose);
    add(calculate);

    calculate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        double as = Double.parseDouble(a2.getText());
        double bs = Double.parseDouble(b2.getText());

        double[] results = Maths.quadDif(as, bs);

        compose.setText("(" + results[0] + "a -" + results[1] + "b)" + "(" + results[0] + "a +" + results[1] + "b)");
      }
    });
  }

}