import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

public class EquationSystem extends FrameStyle {

  private static final long serialVersionUID = 1L;
  private String[] lettersChar = { "x", "y", "z", "w", "u", "v", "p", "q", "r", "s", "t" };

  public EquationSystem(int dim) {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(150 * dim, 200 * dim);
    setResizable(true);
    setLayout(new GridLayout(5, 1));

    // PANEL DE COEFICIENTES
    JPanel allContainer = new JPanel();
    allContainer.setLayout(new GridLayout(1, 3));
    allContainer.setBorder(new EmptyBorder(0, 30, 0, 30));

    JPanel matrixPanel = new JPanel();
    matrixPanel.setLayout(new GridLayout(dim, dim));

    // PANELES DE SEPARACIÓN
    JPanel sumEquals = new JPanel();
    sumEquals.setLayout(new GridLayout(dim, 1));

    // PANEL DE RESPUESTAS
    JPanel resPanel = new JPanel();
    resPanel.setLayout(new GridLayout(dim, 1));

    JLabel respL = new JLabel();
    Font font = respL.getFont().deriveFont(20f);
    respL.setHorizontalAlignment(SwingConstants.CENTER);
    respL.setVerticalAlignment(SwingConstants.CENTER);
    respL.setFont(font);
    respL.setOpaque(true);
    respL.setBackground(new Color(50, 50, 50));
    respL.setForeground(Color.white);

    JLabel title = new JLabel("   Sistema de ecuaciones");
    title.setFont(title.getFont().deriveFont(15f));

    JLabel text = new JLabel("   Resultado: ");
    text.setFont(text.getFont().deriveFont(15f));

    JButton calculate = new JButton("Calcular");
    calculate.setFont(calculate.getFont().deriveFont(18f));
    calculate.setBackground(new Color(21, 101, 192));
    calculate.setForeground(Color.white);

    // MATRICES
    JTextField[][] matrixField = new JTextField[dim][dim];
    JTextField[][] resField = new JTextField[dim][1];

    // AGREGAR VALORES
    for (int i = 0; i < dim; i++) {
      for (int j = 0; j < dim; j++) {
        JTextField ceil = new JTextField();
        ceil.setHorizontalAlignment(SwingConstants.CENTER);
        ceil.setFont(ceil.getFont().deriveFont(24f));
        ceil.setPreferredSize(new Dimension(50, 50));

        matrixField[i][j] = ceil;
        matrixPanel.add(ceil);
      }

      JTextField resFieldS = new JTextField();
      resFieldS.setHorizontalAlignment(SwingConstants.CENTER);
      resFieldS.setFont(resFieldS.getFont().deriveFont(24f));
      resFieldS.setPreferredSize(new Dimension(50, 50));

      JLabel eq = new JLabel("=");
      eq.setHorizontalAlignment(SwingConstants.CENTER);
      eq.setFont(font);
      sumEquals.add(eq);

      JLabel letterL = new JLabel(lettersChar[i] + " + ");
      letterL.setFont(font);
      resField[i][0] = resFieldS;
      resPanel.add(resFieldS);
    }

    allContainer.add(matrixPanel);
    allContainer.add(sumEquals);
    allContainer.add(resPanel);

    add(title);
    add(allContainer);
    add(text);
    add(respL);
    add(calculate);

    calculate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        double[][] mat = new double[dim][dim];
        double[][] res = new double[dim][1];

        for (int i = 0; i < dim; i++) {
          for (int j = 0; j < dim; j++)
            mat[i][j] = Double.parseDouble(matrixField[i][j].getText());

          res[i][0] = Double.parseDouble(resField[i][0].getText());
        }

        try {
          double[] resolve = Maths.quadSystem(mat, res);
          String textLabel = "";

          for (int i = 0; i < dim; i++)
            textLabel += lettersChar[i] + " = " + resolve[i] + ", ";

          respL.setText(textLabel);
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "El sistema no tiene solución.", "Error al resolver",
              JOptionPane.ERROR_MESSAGE);
        }
      }
    });
  }
}
