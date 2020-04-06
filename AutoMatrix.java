import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AutoMatrix extends FrameStyle {
  private static final long serialVersionUID = 1L;
  int dims;
  double[][] mat;
  JTextField[][] matrixCeils;

  private void saveOnMatrix() {
    for (int i = 0; i < dims; i++) {
      for (int j = 0; j < dims; j++) {
        Double value = Double.parseDouble(matrixCeils[i][j].getText());
        mat[i][j] = value;
      }
    }
  }

  public AutoMatrix(int dim, double[][] defValues) {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(320, 200);
    setLayout(new GridLayout(1, 2));
    setResizable(true);

    JPanel btns = new JPanel();
    btns.setLayout(new GridLayout(4, 1));
    JPanel matrix = new JPanel();
    matrix.setLayout(new GridLayout(dim, dim));
    matrixCeils = new JTextField[dim][dim];

    JButton trans = new JButton("Traspuesta");
    Font font = trans.getFont().deriveFont(20f);
    trans.setFont(font);
    trans.setBackground(new Color(21, 101, 192));
    trans.setForeground(Color.white);

    JButton inversa = new JButton("Inversa");
    inversa.setFont(font);
    inversa.setBackground(new Color(21, 101, 192));
    inversa.setForeground(Color.white);

    JButton det = new JButton("Determinante");
    det.setFont(font);
    det.setBackground(new Color(21, 101, 192));
    det.setForeground(Color.white);

    JButton pot = new JButton("Potencia");
    pot.setFont(font);
    pot.setBackground(new Color(21, 101, 192));
    pot.setForeground(Color.white);

    mat = new double[dim][dim];
    dims = dim;

    btns.add(trans);
    btns.add(inversa);
    btns.add(det);
    btns.add(pot);

    for (int i = 0; i < dim; i++) {
      for (int j = 0; j < dim; j++) {
        JTextField ceil = new JTextField();
        ceil.setHorizontalAlignment(SwingConstants.CENTER);
        ceil.setFont(ceil.getFont().deriveFont(24f));
        ceil.setText(Double.toString(defValues[i][j]));

        matrixCeils[i][j] = ceil;
        matrix.add(ceil);
      }
    }

    add(matrix);
    add(btns);

    det.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        saveOnMatrix();
        JOptionPane.showMessageDialog(null, "La determinante es " + Maths.determinante(mat));
      }
    });

    trans.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        saveOnMatrix();
        double[][] transM = Maths.matrizTranspuesta(mat);
        new DrawMatrix(transM);
      }
    });

    inversa.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        saveOnMatrix();
        double[][] inverseM = Maths.matrizInversa(mat);
        new DrawMatrix(inverseM);
      }
    });

    pot.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        saveOnMatrix();
        int pow = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el grado de la potencia"));
        double[][] potencia = mat;

        for (int i = 0; i < pow - 1; i++)
          potencia = Maths.multiplyMatrix(potencia, mat);

        new DrawMatrix(potencia);
      }
    });
  }
}
