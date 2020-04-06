import java.awt.*;
import javax.swing.*;
import java.awt.Color;

public class ArchFrame extends FrameStyle {
  private static final long serialVersionUID = 1L;

  public ArchFrame(int angle, int radius, Double archLength) {
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(300, 500);
    setResizable(true);
    setLayout(new GridLayout(2, 1));
    setBackground(new Color(50, 50, 50));

    JPanel text = new JPanel();
    text.setLayout(new FlowLayout());
    text.setBackground(new Color(50, 50, 50));

    JLabel lengthS = new JLabel(archLength.toString());
    Font font = lengthS.getFont().deriveFont(20f);
    lengthS.setFont(font);
    lengthS.setForeground(Color.white);
    text.add(lengthS);

    ArchPanel draw = new ArchPanel(angle, radius);

    add(text);
    add(draw);
  }

}