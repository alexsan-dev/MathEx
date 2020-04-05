import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculus extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public Calculus() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(300, 200);
    setLayout(new GridLayout(2, 2));

    JButton integrals = new JButton("Integrales");
    JButton derivate = new JButton("Derivadas");
    JButton riemann = new JButton("Riemann");

    add(integrals);
    add(derivate);
    add(riemann);

    riemann.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        new Riemann();
      }
    });

    integrals.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        new Integrals();
      }
    });
  }
}