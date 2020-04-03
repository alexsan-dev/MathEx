import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class QuadBinomial extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public QuadBinomial() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setName("MathX - Algebra");
    setSize(300, 200);
    setLayout(new GridLayout(3, 1));

    // COMPONENTES

    JTextField a2 = new JTextField();
    JLabel a2f = new JLabel("a²");
    JTextField ab = new JTextField();
    JLabel abf = new JLabel("ab");
    JTextField b2 = new JTextField();
    JLabel b2f = new JLabel("b²");

    JLabel compose = new JLabel("(a + b)²");

    JPanel mainline = new JPanel();
    mainline.setLayout(new GridLayout(1, 6));

    JPanel secline = new JPanel();
    secline.setLayout(new GridLayout(1, 1));

    JButton calculate = new JButton("Calcular");

    secline.add(compose);

    mainline.add(a2);
    mainline.add(a2f);
    mainline.add(ab);
    mainline.add(abf);
    mainline.add(b2);
    mainline.add(b2f);

    add(mainline);
    add(secline);
    add(calculate);

    calculate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        int as = Integer.parseInt(a2.getText());
        int bs = Integer.parseInt(ab.getText());
        int cs = Integer.parseInt(b2.getText());
        int[] results = Maths.quadBin(as, bs, cs);

        compose.setText("(" + results[0] + "+" + results[1] + ")² = " + Maths.pow(results[0] + results[1], 2));
      }
    });
  }

}