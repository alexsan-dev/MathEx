import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;

public class Algebra extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public Algebra() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setName("MathX - Algebra");
    setSize(500, 200);
    setLayout(new GridLayout(2, 3));

    HistoryElement hElem = new HistoryElement(0, 2.1, new Date());
    History.addHistory(hElem);

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

    eqSystem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        int dim = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la dimension del sistema de ecuaciones"));
        new EquationSystem(dim);
      }
    });
  }

}