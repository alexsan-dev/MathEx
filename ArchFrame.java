import java.awt.*;
import javax.swing.*;

public class ArchFrame extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public ArchFrame(int angle, int radius, Double archLength) {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setName("MathX - Aritmética");
    setSize(300, 500);
    setResizable(true);
    setLayout(new GridLayout(2, 1));

    JLabel length = new JLabel("Longitud de arco = " + archLength.toString());
    ArchPanel draw = new ArchPanel(angle, radius);

    add(length);
    add(draw);
  }

}