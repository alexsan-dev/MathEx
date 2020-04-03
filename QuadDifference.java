import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class QuadDifference extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public QuadDifference() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setName("MathX - Algebra");
    setSize(300, 200);
    setLayout(new GridLayout(3, 1));

    // COMPONENTES

    JTextField a2 = new JTextField();
    JLabel a2f = new JLabel("a² - ");
    JTextField b2 = new JTextField();
    JLabel b2f = new JLabel("b²");

    JLabel compose = new JLabel("(a - b)(a + b)");

    JPanel mainline = new JPanel();
    mainline.setLayout(new GridLayout(1, 4));

    JPanel secline = new JPanel();
    secline.setLayout(new GridLayout(1, 1));

    JButton calculate = new JButton("Calcular");

    secline.add(compose);

    mainline.add(a2);
    mainline.add(a2f);
    mainline.add(b2);
    mainline.add(b2f);

    add(mainline);
    add(secline);
    add(calculate);

    calculate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        int as = Integer.parseInt(a2.getText());
        int bs = Integer.parseInt(b2.getText());

        int[] results = Maths.quadDif(as, bs);

        compose.setText("(" + results[0] + "-" + results[1] + ")" + "(" + results[0] + "+" + results[1] + ") = "
            + ((results[0] + results[1]) * (results[0] - results[1])));
      }
    });
  }

}