import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SumMatrix extends FrameStyle {
  private static final long serialVersionUID = 1L;
  private double[][] matA, matB;

  private void saveOnMatrix(JTextField[][] ceilsA, JTextField[][] ceilsB, int dims) {
    for (int i = 0; i < dims; i++) {
      for (int j = 0; j < dims; j++) {
        // OBTENER VALOR
        Double valueA = Double.parseDouble(ceilsA[i][j].getText());
        Double valueB = Double.parseDouble(ceilsB[i][j].getText());

        // ASIGNAR VALOR
        matA[i][j] = valueA;
        matB[i][j] = valueB;
      }
    }
  }

  public SumMatrix(int dim) {
    // CONFIGURAR VENTANA
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(350, 300);
    setLayout(new GridLayout(2, 1));

    // MATRICES
    JTextField[][] mA = new JTextField[dim][dim];
    JTextField[][] mB = new JTextField[dim][dim];

    // COMPONENTES
    JComboBox<String> oper = new JComboBox<String>();
    JButton calculate = new JButton("Calcular");

    // PANELES
    JPanel panelA = new JPanel();
    JPanel panelB = new JPanel();
    JPanel matrixContainer = new JPanel();

    // ASIGNAR PROPIEDADES
    matrixContainer.setLayout(new GridLayout(1, 3));
    panelA.setLayout(new GridLayout(dim, dim));
    panelB.setLayout(new GridLayout(dim, dim));

    // VALORES POR DEFECTO
    matA = new double[dim][dim];
    matB = new double[dim][dim];

    // ASIGNAR PROPIEDADES PANEL A
    for (int i = 0; i < dim; i++) {
      for (int j = 0; j < dim; j++) {
        // CREAR CUADRO
        JTextField ceil = new JTextField();
        ceil.setHorizontalAlignment(SwingConstants.CENTER);
        ceil.setFont(ceil.getFont().deriveFont(24f));

        // ASIGNAR A LISTA
        mA[i][j] = ceil;

        // AUMENTAR CONTADOR
        panelA.add(ceil);
      }
    }

    // ASIGNAR PROPIEDADES PANEL B
    for (int i = 0; i < dim; i++) {
      for (int j = 0; j < dim; j++) {
        // CREAR CUADRO
        JTextField ceil = new JTextField();
        ceil.setHorizontalAlignment(SwingConstants.CENTER);
        ceil.setFont(ceil.getFont().deriveFont(24f));

        // ASIGNAR A LISTA
        mB[i][j] = ceil;

        // AUMENTAR CONTADOR
        panelB.add(ceil);
      }
    }

    // EVENTOS
    calculate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        // GUARDAR MATRICES
        Boolean mode = oper.getSelectedIndex() == 0;
        saveOnMatrix(mA, mB, dim);

        // MOSTRAR MATRIZ
        new DrawMatrix(Maths.sumMatrix(matA, matB, mode));
      }
    });

    // ASIGNAR ELEMENTOS
    oper.addItem("SUMAR");
    oper.addItem("RESTAR");
    matrixContainer.add(panelA);
    matrixContainer.add(oper);
    matrixContainer.add(panelB);

    // ASIGNAR A LAYOUT PRINCIPAL
    add(matrixContainer);
    add(calculate);
  }
}