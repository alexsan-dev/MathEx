import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class QuadBinomial extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public QuadBinomial() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setName("MathX - Algebra");
    setSize(350, 300);
    setLayout(new GridLayout(5, 1));
    setResizable(true);

    // COMPONENTES
    JLabel title = new JLabel("   Ecuación cuadrática");
    title.setFont(title.getFont().deriveFont(15f));

    JLabel text = new JLabel("   Resultado: ");
    text.setFont(text.getFont().deriveFont(15f));

    JTextField a2 = new JTextField();
    Font font = a2.getFont().deriveFont(24f);
    a2.setFont(font);
    a2.setHorizontalAlignment(SwingConstants.CENTER);
    a2.setPreferredSize(new Dimension(50, 50));

    JLabel a2f = new JLabel("a²+");
    a2f.setFont(font);

    JTextField ab = new JTextField();
    ab.setFont(font);
    ab.setHorizontalAlignment(SwingConstants.CENTER);
    ab.setPreferredSize(new Dimension(50, 50));

    JLabel abf = new JLabel("ab+");
    abf.setFont(font);

    JTextField b2 = new JTextField();
    b2.setFont(font);
    b2.setHorizontalAlignment(SwingConstants.CENTER);
    b2.setPreferredSize(new Dimension(50, 50));

    JLabel b2f = new JLabel("b²");
    b2f.setFont(font);

    JLabel result = new JLabel("(a + b)²");
    result.setHorizontalAlignment(SwingConstants.CENTER);
    result.setVerticalAlignment(SwingConstants.CENTER);
    result.setFont(font);
    result.setOpaque(true);
    result.setBackground(new Color(50, 50, 50));
    result.setForeground(Color.white);

    JPanel mainline = new JPanel();
    mainline.setLayout(new FlowLayout());

    JButton calculate = new JButton("Calcular");
    calculate.setFont(calculate.getFont().deriveFont(18f));
    calculate.setBackground(new Color(21, 101, 192));
    calculate.setForeground(Color.white);

    mainline.add(a2);
    mainline.add(a2f);
    mainline.add(ab);
    mainline.add(abf);
    mainline.add(b2);
    mainline.add(b2f);

    add(title);
    add(mainline);
    add(text);
    add(result);
    add(calculate);

    calculate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        double as = Double.parseDouble(a2.getText());
        double bs = Double.parseDouble(ab.getText());
        double cs = Double.parseDouble(b2.getText());
        double[] results = Maths.quadBin(as, bs, cs);

        if (results[0] == -1.0 && results[1] == -1.0)
          JOptionPane.showMessageDialog(null,
              "Los coeficientes no cumplen las condiciones de binomio cuadrado perfecto.", "Error al factorizar",
              JOptionPane.ERROR_MESSAGE);
        else
          result.setText("(" + results[1] + "a + " + results[0] + "b)²");
      }
    });
  }
}