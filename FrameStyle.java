import java.awt.*;
import javax.swing.*;

public class FrameStyle extends JFrame {
  private static final long serialVersionUID = 1L;

  public FrameStyle() {
    // AGREGAR NOMBRE
    super("MathX - Java Calculator");

    // AGREGAR ICONO Y COLOR
    setIconImage(new ImageIcon("assets/icon.png").getImage());
    setBackground(new Color(255, 255, 255));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // AGREGAR DIMENSIONES
    setResizable(false);
    setVisible(true);
  }

  public FrameStyle(String name) {
    super(name);
  }
}