import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class QuadEquation extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public QuadEquation() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(300, 300);
    setLayout(new GridLayout(5, 1));
    setResizable(true);

    // COMPONENTES

    JLabel title = new JLabel("   Ecuación cuadrática");
    title.setFont(title.getFont().deriveFont(15f));

    JLabel text = new JLabel("   Resultado: ");
    text.setFont(text.getFont().deriveFont(15f));

    JTextField a = new JTextField();
    Font font = a.getFont().deriveFont(24f);
    a.setFont(font);
    a.setHorizontalAlignment(SwingConstants.CENTER);
    a.setPreferredSize(new Dimension(50, 50));

    JLabel x2 = new JLabel("x² + ");
    x2.setFont(font);

    JTextField b = new JTextField();
    b.setFont(font);
    b.setHorizontalAlignment(SwingConstants.CENTER);
    b.setPreferredSize(new Dimension(50, 50));

    JLabel x = new JLabel("x + ");
    x.setFont(font);

    JTextField c = new JTextField();
    c.setFont(font);
    c.setHorizontalAlignment(SwingConstants.CENTER);
    c.setPreferredSize(new Dimension(50, 50));

    JLabel result = new JLabel();
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

    mainline.add(a);
    mainline.add(x2);
    mainline.add(b);
    mainline.add(x);
    mainline.add(c);

    add(title);
    add(mainline);
    add(text);
    add(result);
    add(calculate);

    calculate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        int as = Integer.parseInt(a.getText());
        int bs = Integer.parseInt(b.getText());
        int cs = Integer.parseInt(c.getText());
        Double[] results = Maths.quadEq(as, bs, cs);

        result.setText("x = " + results[0] + ", x = " + results[1]);
      }
    });
  }

}