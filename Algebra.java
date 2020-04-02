import java.awt.*;
import javax.swing.*;

public class Algebra extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public Algebra() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setName("MathX - Algebra");
    setSize(300, 200);
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
  }

}