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
    setSize(200 * dim, 200);
    setLayout(new GridBagLayout());
    setResizable(true);

    // MATRICES
    JTextField[][] mA = new JTextField[dim][dim];
    JTextField[][] mB = new JTextField[dim][dim];

    // COMPONENTES
    JComboBox<String> oper = new JComboBox<String>();
    oper.setFont(oper.getFont().deriveFont(20f));

    JButton calculate = new JButton("Calcular");
    calculate.setFont(calculate.getFont().deriveFont(18f));
    calculate.setBackground(new Color(21, 101, 192));
    calculate.setForeground(Color.white);

    // PANELES
    JPanel panelA = new JPanel();
    JPanel panelB = new JPanel();
    JPanel matrixContainer = new JPanel();

    // ASIGNAR PROPIEDADES
    matrixContainer.setLayout(new FlowLayout());
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
        ceil.setPreferredSize(new Dimension(50, 50));
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
        ceil.setPreferredSize(new Dimension(50, 50));

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
    oper.addItem("+");
    oper.addItem("-");
    matrixContainer.add(panelA);
    matrixContainer.add(oper);
    matrixContainer.add(panelB);

    // ASIGNAR A LAYOUT PRINCIPAL
    add(matrixContainer);
    add(calculate);
  }
}