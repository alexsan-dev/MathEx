import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MultiplyMatrix extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public MultiplyMatrix(String dimA, String dimB) {
    // CONFIGURAR VENTANA
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setLayout(new GridLayout(2, 1));
    setSize(300, 250);

    // DIMENSIONES
    String[] dimsAS = dimA.split("x");
    int[] dimsA = { Integer.parseInt(dimsAS[0]), Integer.parseInt(dimsAS[1]) };
    String[] dimsBS = dimB.split("x");
    int[] dimsB = { Integer.parseInt(dimsBS[0]), Integer.parseInt(dimsBS[1]) };

    // MATRICES
    double[][] matA = new double[dimsA[0]][dimsA[1]];
    double[][] matB = new double[dimsB[0]][dimsB[1]];

    // COMPONENTES
    JPanel mA = new JPanel();
    mA.setLayout(new GridLayout(dimsA[0], dimsA[1]));

    JPanel mB = new JPanel();
    mB.setLayout(new GridLayout(dimsB[0], dimsB[1]));

    JPanel matrixContainer = new JPanel();
    matrixContainer.setLayout(new GridLayout(1, 3));

    JLabel sign = new JLabel("x");
    JButton calculate = new JButton("Calcular");
    JTextField[][] matAFields = new JTextField[dimsA[0]][dimsA[1]];
    JTextField[][] matBFields = new JTextField[dimsA[0]][dimsA[1]];

    // AGREGAR INPUT FIELDS
    for (int i = 0; i < dimsA[0]; i++) {
      for (int j = 0; j < dimsA[1]; j++) {
        JTextField ceil = new JTextField();
        ceil.setHorizontalAlignment(SwingConstants.CENTER);
        ceil.setFont(ceil.getFont().deriveFont(24f));
        matAFields[i][j] = ceil;
        mA.add(ceil);
      }
    }

    // AGREGAR INPUT FIELDS
    for (int i = 0; i < dimsB[0]; i++) {
      for (int j = 0; j < dimsB[1]; j++) {
        JTextField ceil = new JTextField();
        ceil.setHorizontalAlignment(SwingConstants.CENTER);
        ceil.setFont(ceil.getFont().deriveFont(24f));
        matBFields[i][j] = ceil;
        mB.add(ceil);
      }
    }

    // PROPIEDADES
    sign.setFont(sign.getFont().deriveFont(24f));
    calculate.setFont(calculate.getFont().deriveFont(24f));

    // AGREGAR COMPONENTES
    matrixContainer.add(mA);
    matrixContainer.add(sign);
    matrixContainer.add(mB);

    add(matrixContainer);
    add(calculate);

    calculate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        for (int i = 0; i < dimsA[0]; i++)
          for (int j = 0; j < dimsA[1]; j++)
            matA[i][j] = Double.parseDouble(matAFields[i][j].getText());

        for (int i = 0; i < dimsB[0]; i++)
          for (int j = 0; j < dimsB[1]; j++)
            matB[i][j] = Double.parseDouble(matBFields[i][j].getText());

        double[][] res = Maths.multiplyMatrix(matA, matB);

        new DrawMatrix(res);
      }
    });

  }
}