import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class OMatrix extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public OMatrix() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(500, 100);
    setLayout(new GridLayout(2, 3));

    JLabel auto = new JLabel("Automático, dimension: ");
    JTextField autoF = new JTextField();
    JButton goAuto = new JButton("Ver operaciones");

    JLabel manual = new JLabel("Manual, 1, 2, 4, ...");
    JTextField manualF = new JTextField();
    JButton goManual = new JButton("Ver operaciones");

    add(auto);
    add(autoF);
    add(goAuto);
    add(manual);
    add(manualF);
    add(goManual);

    goAuto.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        int dim = Integer.parseInt(autoF.getText());
        double[][] defValues = new double[dim][dim];

        new AutoMatrix(dim, defValues);
      }
    });

    goManual.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        String[] textValues = manualF.getText().split(",");
        double[] values = new double[textValues.length];
        int dim = (int) Math.sqrt(textValues.length);
        double[][] defValues = new double[dim][dim];
        int asyncCount = 0;

        System.out.println(textValues.length);

        for (int i = 0; i < textValues.length; i++)
          values[i] = Double.parseDouble(textValues[i]);

        for (int i = 0; i < dim; i++) {
          for (int j = 0; j < dim; j++) {
            defValues[i][j] = values[asyncCount];
            asyncCount++;
          }
        }

        new AutoMatrix(dim, defValues);
      }
    });
  }
}