import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TMatrix extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public TMatrix() {
    // CONFIGURAR VENTANA
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(400, 100);
    setLayout(new GridLayout(1, 2));

    // CREAR COMPONENTES
    JButton sum = new JButton("Suma o resta");
    JButton mult = new JButton("Multiplicación");

    // AGREGAR EVENTOS
    sum.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        int dim = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la dimensión de las matrices"));
        new SumMatrix(dim);
      }
    });

    mult.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        String dimA = JOptionPane.showInputDialog(null, "Ingresa la dimensión de la matriz A ( IxJ )");
        String dimB = JOptionPane.showInputDialog(null, "Ingresa la dimensión de la matriz B ( IxJ )");
        int dimAJ = Integer.parseInt(dimA.split("x")[1]);
        int dimBi = Integer.parseInt(dimB.split("x")[0]);

        if (dimAJ == dimBi)
          new MultiplyMatrix(dimA, dimB);
        else
          JOptionPane.showMessageDialog(null, "Las matrices no tienen la dimension correcta para multiplicarse",
              "Error al multiplicar", JOptionPane.ERROR_MESSAGE);
      }
    });

    // AGREGAR BOTONES
    add(sum);
    add(mult);
  }
}