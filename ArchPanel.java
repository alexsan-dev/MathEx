import java.awt.*;
import javax.swing.*;
import java.awt.Color;

public class ArchPanel extends JPanel {
  private static final long serialVersionUID = 1L;
  private int angle, radius;

  public ArchPanel(int angle, int radius) {
    this.angle = angle;
    this.radius = radius;

    setBackground(new Color(50, 50, 50));
    setLayout(new FlowLayout());
    setAlignmentX(SwingConstants.CENTER);
  }

  public void paintComponent(Graphics g) {
    g.setColor(new Color(21, 101, 192));
    g.fillArc(0, 0, radius * 55, radius * 55, 0, angle);
  }

}
