import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Algebra extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public Algebra() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setName("MathX - Algebra");
    setSize(500, 200);
    setLayout(new GridLayout(2, 3));

    // COMPONENTES
    final JButton quadEquation = new JButton("Cuadrática");
    final JButton eqSystem = new JButton("Sistema de ecuaciones");
    final JButton binomio = new JButton("Binomio cuadrado");
    final JButton quadSum = new JButton("Suma de cuadrados");
    final JButton cubic = new JButton("Suma y diferencia de cubos");

    add(quadEquation);
    add(eqSystem);
    add(binomio);
    add(quadSum);
    add(cubic);

    quadEquation.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        new QuadEquation();
      }
    });

    binomio.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        new QuadBinomial();
      }
    });

    quadSum.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        new QuadDifference();
      }
    });
  }

}