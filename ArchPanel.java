import java.awt.Graphics;
import javax.swing.JPanel;

import java.awt.Color;

public class ArchPanel extends JPanel {
  private static final long serialVersionUID = 1L;
  private int angle, radius;

  public ArchPanel(int angle, int radius) {
    this.angle = angle;
    this.radius = radius;
  }

  public void paintComponent(Graphics g) {
    g.setColor(Color.BLUE);
    g.fillArc(0, 0, radius * 55, radius * 55, 0, angle);
  }
}