import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

public class OMatrix extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public OMatrix() {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(500, 150);

    JPanel container = new JPanel();
    container.setLayout(new GridLayout(2, 3));

    container.setBorder(new EmptyBorder(20, 20, 20, 20));

    JLabel auto = new JLabel("Automático, dimension: ");
    JTextField autoF = new JTextField();
    JButton goAuto = new JButton("Ver operaciones");
    goAuto.setBackground(new Color(21, 101, 192));
    goAuto.setForeground(Color.white);

    JLabel manual = new JLabel("Manual, 1, 2, 4, 5, 6 ...");
    JTextField manualF = new JTextField();

    JButton goManual = new JButton("Ver operaciones");
    goManual.setBackground(new Color(21, 101, 192));
    goManual.setForeground(Color.white);

    container.add(auto);
    container.add(autoF);
    container.add(goAuto);
    container.add(manual);
    container.add(manualF);
    container.add(goManual);

    add(container);

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