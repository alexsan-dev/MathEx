import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class QuadEquation extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public QuadEquation() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setName("MathX - Algebra");
    setSize(300, 200);
    setLayout(new GridLayout(3, 1));

    // COMPONENTES

    JTextField a = new JTextField();
    Font font = a.getFont().deriveFont(24f);
    a.setFont(font);

    JLabel x2 = new JLabel("x² + ");
    x2.setFont(font);

    JTextField b = new JTextField();
    b.setFont(font);

    JLabel x = new JLabel("x + ");
    x.setFont(font);

    JTextField c = new JTextField();
    c.setFont(font)

    JLabel result = new JLabel();
    result.setHorizontalAlignment(SwingConstants.CENTER);
    result.setVerticalAlignment(SwingConstants.CENTER);
    result.setFont(font);
    result.setOpaque(true);
    result.setBackground(new Color(50, 50, 50));
    result.setForeground(Color.white);

    JPanel mainline = new JPanel();
    mainline.setLayout(new FlowLayout());

    JPanel secline = new JPanel();
    secline.setLayout(new FlowLayout());

    JButton calculate = new JButton("Calcular");
    calculate.setFont(calculate.getFont().deriveFont(18f));
    calculate.setBackground(new Color(21, 101, 192));
    calculate.setForeground(Color.white);



    mainline.add(a);
    mainline.add(x2);
    mainline.add(b);
    mainline.add(x);
    mainline.add(c);

    secline.add(result);

    add(mainline);
    add(secline);
    add(calculate);

    calculate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        int as = Integer.parseInt(a.getText());
        int bs = Integer.parseInt(b.getText());
        int cs = Integer.parseInt(c.getText());
        Double[] results = Maths.quadEq(as, bs, cs);

        x0f.setText(results[0].toString());
        x1f.setText(results[1].toString());
      }
    });
  }

}