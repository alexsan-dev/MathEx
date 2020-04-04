import java.awt.*;
import javax.swing.*;

public class DrawMatrix extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public DrawMatrix(double[][] mat) {
    int n = mat.length;
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(200, 200);
    setLayout(new GridLayout(n, n));

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        JTextField ceil = new JTextField();
        Double value = mat[i][j];

        ceil.setText(Double.toString(value));
        ceil.setHorizontalAlignment(SwingConstants.CENTER);
        ceil.setFont(ceil.getFont().deriveFont(24f));
        ceil.setEditable(false);

        add(ceil);
      }
    }
  }
}