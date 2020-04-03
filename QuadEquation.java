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
    JLabel x2 = new JLabel("x²");
    JTextField b = new JTextField();
    JLabel x = new JLabel("x");
    JTextField c = new JTextField();

    JLabel x0 = new JLabel("x0 = ");
    JTextField x0f = new JTextField();
    JLabel x1 = new JLabel("x1 = ");
    JTextField x1f = new JTextField();

    JPanel mainline = new JPanel();
    mainline.setLayout(new GridLayout(1, 5));

    JPanel secline = new JPanel();
    secline.setLayout(new GridLayout(1, 4));

    JButton calculate = new JButton("Calcular");

    secline.add(x0);
    secline.add(x0f);
    secline.add(x1);
    secline.add(x1f);

    mainline.add(a);
    mainline.add(x2);
    mainline.add(b);
    mainline.add(x);
    mainline.add(c);

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