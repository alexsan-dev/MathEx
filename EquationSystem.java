import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EquationSystem extends FrameStyle {

  private static final long serialVersionUID = 1L;
  private String[] lettersChar = { "x", "y", "z", "w", "u", "v", "p", "q", "r", "s", "t" };

  public EquationSystem(int dim) {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(300, 300);
    setLayout(new GridLayout(4, 1));

    // PANEL DE COEFICIENTES
    JPanel allContainer = new JPanel();
    allContainer.setLayout(new GridLayout(1, 3));

    JPanel matrixPanel = new JPanel();
    matrixPanel.setLayout(new GridLayout(dim, 1));

    // PANELES DE SEPARACIÓN
    JPanel letters = new JPanel();
    letters.setLayout(new GridLayout(1, dim));
    JPanel sumEquals = new JPanel();
    sumEquals.setLayout(new GridLayout(dim, 1));

    // PANEL DE RESPUESTAS
    JPanel resPanel = new JPanel();
    resPanel.setLayout(new GridLayout(dim, 1));

    JLabel respL = new JLabel();
    JButton calculate = new JButton("Calcular");

    // MATRICES
    JTextField[][] matrixField = new JTextField[dim][dim];
    JTextField[][] resField = new JTextField[dim][1];

    // AGREGAR VALORES
    for (int i = 0; i < dim; i++) {
      for (int j = 0; j < dim; j++) {
        JTextField ceil = new JTextField();
        ceil.setHorizontalAlignment(SwingConstants.CENTER);
        ceil.setFont(ceil.getFont().deriveFont(24f));
        matrixField[i][j] = ceil;
        matrixPanel.add(ceil);
      }

      JTextField resFieldS = new JTextField();
      resFieldS.setHorizontalAlignment(SwingConstants.CENTER);
      resFieldS.setFont(resFieldS.getFont().deriveFont(24f));

      JLabel eq = new JLabel("=");
      sumEquals.add(eq);

      JLabel letterL = new JLabel(lettersChar[i]);

      resField[i][0] = resFieldS;
      resPanel.add(resFieldS);

      letters.add(letterL);
    }

    allContainer.add(matrixPanel);
    allContainer.add(sumEquals);
    allContainer.add(resPanel);

    add(letters);
    add(allContainer);
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

        double[] resolve = Maths.quadSystem(mat, res);
        String textLabel = "";

        for (int i = 0; i < dim; i++)
          textLabel += lettersChar[i] + " = " + resolve[i] + ", ";

        respL.setText(textLabel);
      }
    });
  }
}
