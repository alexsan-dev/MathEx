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
        new AutoMatrix(dim);
      }
    });
  }
}